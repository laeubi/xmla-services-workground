package org.eclipse.daanse.ws.api.whiteboard.prototypes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.daanse.ws.api.whiteboard.SoapWhiteboardConstants;
import org.eclipse.daanse.ws.api.whiteboard.annotations.RequireSoapWhiteboard;
import org.osgi.service.component.annotations.ComponentPropertyType;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({
		ElementType.TYPE
})
@RequireSoapWhiteboard
@ComponentPropertyType
public @interface EndpointSelector {
	
	String PREFIX_ = SoapWhiteboardConstants.SOAP_PREFIX;
	
	String value();

}
