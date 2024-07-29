/*
* Copyright (c) 2023 Contributors to the Eclipse Foundation.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*   SmartCity Jena - initial
*   Stefan Bischof (bipolis.org) - initial
*   Christoph Läubrich - initial
*/
package org.eclipse.daanse.ws.runtime.registrar;

import java.lang.annotation.Annotation;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import org.eclipse.daanse.ws.runtime.registrar.spi.EndpointPublisher;
import org.eclipse.daanse.ws.runtime.registrar.spi.PublishedEndpoint;
import org.osgi.annotation.bundle.Capability;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.dto.ServiceReferenceDTO;
import org.osgi.namespace.implementation.ImplementationNamespace;
import org.osgi.service.component.AnyService;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.osgi.service.jakartaws.runtime.WebserviceServiceRuntime;
import org.osgi.service.jakartaws.runtime.dto.EndpointDTO;
import org.osgi.service.jakartaws.runtime.dto.FailedHandlerDTO;
import org.osgi.service.jakartaws.runtime.dto.HandlerDTO;
import org.osgi.service.jakartaws.runtime.dto.RuntimeDTO;
import org.osgi.service.jakartaws.whiteboard.SoapWhiteboardConstants;
import org.osgi.service.log.Logger;
import org.osgi.service.log.LoggerFactory;

import jakarta.xml.ws.Endpoint;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.handler.Handler;
import jakarta.xml.ws.handler.MessageContext;

@Component(immediate = true, service = { WebserviceServiceRuntime.class })
@Capability(namespace = ImplementationNamespace.IMPLEMENTATION_NAMESPACE, //
		name = SoapWhiteboardConstants.SOAP, //
		version = SoapWhiteboardConstants.SOAP_SPECIFICATION_VERSION)
public class EndpointRegistrar implements WebserviceServiceRuntime {

	private Logger logger;

	private Map<Bundle, BundleEndpointContext> contextMap = new WeakHashMap<>();
	private Map<ServiceReference<?>, HandlerInfo> handlerMap = new ConcurrentHashMap<>();
	private Map<ServiceReference<?>, EndpointRegistration> endpointRegistrations = new ConcurrentHashMap<>();
	private Map<EndpointPublisher, ServiceRanking> endpointPublisherMap = new ConcurrentHashMap<>();
	private ComponentContext context;

	@Activate
	public EndpointRegistrar(@Reference(service = LoggerFactory.class) Logger logger, ComponentContext context) {
		this.logger = logger;
		this.context = context;
	}

	@Reference(cardinality = ReferenceCardinality.AT_LEAST_ONE, policy = ReferencePolicy.DYNAMIC)
	// public void addEndpointPublisher(EndpointPublisher publisher, ServiceRanking
	// ranking) {
	public void addEndpointPublisher(EndpointPublisher publisher, Map<String, ?> properties) {
		ServiceRanking ranking = new ServiceRanking() {

			@Override
			public Class<? extends Annotation> annotationType() {
				return ServiceRanking.class;
			}

			@Override
			public int value() {
				Object object = properties.get(Constants.SERVICE_RANKING);
				if (object instanceof Integer) {
					return ((Integer) object).intValue();
				}
				return 0;
			}
		};
		System.out.println("EndpointRegistrar.addEndpointPublisher() " + publisher + " with ranking " + ranking);
		logger.debug("BINDING publisher={} with ranking={}", publisher, ranking);
		endpointPublisherMap.put(publisher, ranking);
		updateAll();
	}

	public void removeEndpointPublisher(EndpointPublisher publisher) {
		System.out.println("EndpointRegistrar.removeEndpointPublisher()");
		ServiceRanking ranking = endpointPublisherMap.remove(publisher);
		logger.debug("UNBINDING publisher={} with ranking={}", publisher, ranking);
		updateAll();
	}

	@Reference(service = AnyService.class, target = "(" + SoapWhiteboardConstants.SOAP_ENDPOINT_IMPLEMENTOR
			+ "=true)", cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY)
	public void bindEndpointImplementor(ServiceReference<?> endpointImplementorReference) {
		System.out.println("EndpointRegistrar.bindEndpointImplementor()");
		logger.debug("BINDING implementor={}", endpointImplementorReference);
		EndpointRegistration registration = new EndpointRegistration(endpointImplementorReference);
		EndpointRegistration replaced = endpointRegistrations.put(endpointImplementorReference, registration);
		if (replaced != null) {
			replaced.dispose();
		}
		registration.refresh();
	}

	public void unbindEndpointImplementor(ServiceReference<?> endpointImplementorReference) {
		logger.debug("UNBINDING implementor={}", endpointImplementorReference);
		EndpointRegistration registration = endpointRegistrations.remove(endpointImplementorReference);
		if (registration != null) {
			registration.dispose();
		}
	}

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	public void addHandler(ServiceReference<Handler<? extends MessageContext>> handler) {
		HandlerInfo info = handlerMap.put(handler, new HandlerInfo(handler, context.getBundleContext()));
		if (info != null) {
			info.dispose();
		}
		updateAll();
	}

	public void updateHandler(ServiceReference<Handler<? extends MessageContext>> handler) {
		HandlerInfo info = handlerMap.put(handler, new HandlerInfo(handler, context.getBundleContext()));
		if (info != null) {
			info.dispose();
		}
		updateAll();
	}

	public void removeHandler(ServiceReference<Handler<? extends MessageContext>> handler) {
		logger.debug("REMOVE handler={}", handler);
		HandlerInfo info = handlerMap.remove(handler);
		if (info != null) {
			info.dispose();
			updateAll();
		}
	}

	private void updateAll() {
		logger.debug("Update all handlers...");
		endpointRegistrations.values().stream().forEach(EndpointRegistration::refresh);
	}

	private final class EndpointRegistration {

		private List<HandlerInfo> handlerChain;
		private final ServiceReference<?> implementorReference;
		private PublishedEndpoint publishedEndpoint;

		public EndpointRegistration(ServiceReference<?> implementorReference) {
			this.implementorReference = implementorReference;
		}

		public void refresh() {
			synchronized (this) {
				System.out.println("EndpointRegistrar.EndpointRegistration.refresh()");
				if (endpointPublisherMap.isEmpty()) {
					// TODO error code as failed endpoint?
					System.out.println("no publishers yet!");
					return;
				}

				Dictionary<String, Object> dictionaryProperties = getServiceProperties();
				BundleContext bc = context.getBundleContext();
				Object implementor = bc.getService(implementorReference);

				System.out.println("implementor=" + implementor);
				internalDispose();
				// the implementor might be prototype scope so better look it up on each call
				if (implementor == null) {
					// TODO add as failed endpoint!
					// not valid anymore?!
					return;
				}
				handlerChain = handlers(dictionaryProperties).toList();
				try {
					Endpoint endpoint = Endpoint.create(implementor);
					try {
						endpoint.getBinding().setHandlerChain(handlerChain.stream().map(info -> info.fetchHandler())
								.filter(Objects::nonNull).map(Handler.class::cast).toList());
					} catch (UnsupportedOperationException | WebServiceException e) {
						// can't set a handler chain then!
						logger.warn("Can't update handler chain for {}: {}", endpoint, e.toString());
					}
					endpoint.setProperties(FrameworkUtil.asMap(dictionaryProperties));
					BundleEndpointContext context = contextMap.computeIfAbsent(implementorReference.getBundle(),
							BundleEndpointContext::new);
					context.addEndpoint(endpoint);
					endpoint.setEndpointContext(context);
					System.out.println("endpointPublisherMap = " + endpointPublisherMap);
					publishedEndpoint = endpointPublisherMap.entrySet().stream()
							.sorted(Comparator.comparing(Entry::getValue,
									Comparator.comparingInt(ServiceRanking::value)))
							.map(Entry::getKey).map(publisher -> publisher.publishEndpoint(endpoint))
							.filter(Objects::nonNull).map(delegate -> new PublishedEndpoint() {
								@Override
								public String getAddress() {
									return delegate.getAddress();
								}

								@Override
								public void unpublish() {
									context.removeEndpoint(endpoint);
									try {
										delegate.unpublish();
									} finally {
										bc.ungetService(implementorReference);
									}
								}

							}).findFirst().orElse(null);
				} catch (RuntimeException e) {
					e.printStackTrace();
					publishedEndpoint = new FailedEndpoint(e, implementor) {

						@Override
						public void unpublish() {
							bc.ungetService(implementorReference);
						}
					};
				}
			}
		}

		public void dispose() {
			synchronized (this) {
				internalDispose();
			}
		}

		private void internalDispose() {
			if (publishedEndpoint != null) {
				try {
					publishedEndpoint.unpublish();
				} catch (RuntimeException e) {
					// ignore
				}
				publishedEndpoint = null;
			}
		}

		private Dictionary<String, Object> getServiceProperties() {
			Hashtable<String, Object> hashtable = new Hashtable<>();
			Dictionary<String, Object> properties = implementorReference.getProperties();
			Enumeration<String> keys = properties.keys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				if (key.startsWith(".")) {
					// do not propagate secret properties
					continue;
				}
				if (SoapWhiteboardConstants.SOAP_ENDPOINT_IMPLEMENTOR.equals(key)) {
					// don't propagate the implementor as otherwise this service will be assumed to
					// be an implementor as well
					continue;
				}
				hashtable.put(key, properties.get(key));
			}
			return hashtable;
		}

		private Stream<HandlerInfo> handlers(Dictionary<String, ?> properties) {
			return handlerMap.values().stream().filter(handlerInfo -> handlerInfo.matches(properties))
					.sorted(HandlerInfo.SORT_BY_PRIORITY);
		}

		private EndpointDTO getEndpointDTO() {
			EndpointDTO dto;
			synchronized (this) {
				if (publishedEndpoint == null || publishedEndpoint instanceof FailedEndpoint) {
					// currently not published or publish failed
					return null;
				}
				dto = new EndpointDTO();
				dto.address = publishedEndpoint.getAddress();
				dto.handlers = handlerChain.stream().map(hi -> hi.getDto()).filter(Objects::nonNull)
						.toArray(HandlerDTO[]::new);
			}
			dto.implementor = implementorReference.adapt(ServiceReferenceDTO.class);
			return dto;
		}
	}

	@Override
	public RuntimeDTO getRuntimeDTO() {
		RuntimeDTO runtimeDTO = new RuntimeDTO();
		runtimeDTO.endpoints = endpointRegistrations.values().stream().map(EndpointRegistration::getEndpointDTO)
				.filter(Objects::nonNull).toArray(EndpointDTO[]::new);
		runtimeDTO.handlers = handlerMap.values().stream().map(hi -> hi.getDto()).filter(Objects::nonNull)
				.toArray(HandlerDTO[]::new);
		runtimeDTO.failedHandlers = handlerMap.values().stream().map(hi -> hi.getFailedDto()).filter(Objects::nonNull)
				.toArray(FailedHandlerDTO[]::new);
		runtimeDTO.serviceReference = context.getServiceReference().adapt(ServiceReferenceDTO.class);
		return runtimeDTO;
	}

	private static abstract class FailedEndpoint implements PublishedEndpoint {

		private RuntimeException e;
		private Object implObject;

		public FailedEndpoint(RuntimeException e, Object implObject) {
			this.e = e;
			this.implObject = implObject;
		}

		@Override
		public String getAddress() {
			return null;
		}

		@Override
		public String toString() {
			return "Failed publish of implementor " + implObject + ": " + e;
		}
	}

}
