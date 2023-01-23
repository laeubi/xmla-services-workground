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
*/
package org.eclipse.daanse.xmla.model.jaxb.xmla;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Command" type="{urn:schemas-microsoft-com:xml-analysis}Command"/&gt;
 *         &lt;element name="Properties"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PropertyList" type="{urn:schemas-microsoft-com:xml-analysis}PropertyList" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Parameters" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Parameter" type="{urn:schemas-microsoft-com:xml-analysis}ExecuteParameter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "command", "properties", "parameters" })
@XmlRootElement(name = "Execute")
public class Execute {

  @XmlElement(name = "Command", required = true)
  protected Command command;
  @XmlElement(name = "Properties", required = true)
  protected Execute.Properties properties;
  @XmlElement(name = "Parameters")
  protected Execute.Parameters parameters;

  /**
   * Gets the value of the command property.
   * 
   * @return possible object is {@link Command }
   * 
   */
  public Command getCommand() {
    return command;
  }

  /**
   * Sets the value of the command property.
   * 
   * @param value allowed object is {@link Command }
   * 
   */
  public void setCommand(Command value) {
    this.command = value;
  }

  public boolean isSetCommand() {
    return (this.command != null);
  }

  /**
   * Gets the value of the properties property.
   * 
   * @return possible object is {@link Execute.Properties }
   * 
   */
  public Execute.Properties getProperties() {
    return properties;
  }

  /**
   * Sets the value of the properties property.
   * 
   * @param value allowed object is {@link Execute.Properties }
   * 
   */
  public void setProperties(Execute.Properties value) {
    this.properties = value;
  }

  public boolean isSetProperties() {
    return (this.properties != null);
  }

  /**
   * Gets the value of the parameters property.
   * 
   * @return possible object is {@link Execute.Parameters }
   * 
   */
  public Execute.Parameters getParameters() {
    return parameters;
  }

  /**
   * Sets the value of the parameters property.
   * 
   * @param value allowed object is {@link Execute.Parameters }
   * 
   */
  public void setParameters(Execute.Parameters value) {
    this.parameters = value;
  }

  public boolean isSetParameters() {
    return (this.parameters != null);
  }

  /**
   * <p>
   * Java class for anonymous complex type.
   * 
   * <p>
   * The following schema fragment specifies the expected content contained within
   * this class.
   * 
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="Parameter" type="{urn:schemas-microsoft-com:xml-analysis}ExecuteParameter" maxOccurs="unbounded" minOccurs="0"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   * 
   * 
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = { "parameter" })
  public static class Parameters {

    @XmlElement(name = "Parameter")
    protected List<ExecuteParameter> parameter;

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot.
     * Therefore any modification you make to the returned list will be present
     * inside the Jakarta XML Binding object. This is why there is not a
     * <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExecuteParameter }
     * 
     * 
     */
    public List<ExecuteParameter> getParameter() {
      if (parameter == null) {
        parameter = new ArrayList<ExecuteParameter>();
      }
      return this.parameter;
    }

    public boolean isSetParameter() {
      return ((this.parameter != null) && (!this.parameter.isEmpty()));
    }

    public void unsetParameter() {
      this.parameter = null;
    }

  }

  /**
   * <p>
   * Java class for anonymous complex type.
   * 
   * <p>
   * The following schema fragment specifies the expected content contained within
   * this class.
   * 
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="PropertyList" type="{urn:schemas-microsoft-com:xml-analysis}PropertyList" minOccurs="0"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   * 
   * 
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = { "propertyList" })
  public static class Properties {

    @XmlElement(name = "PropertyList")
    protected PropertyList propertyList;

    /**
     * Gets the value of the propertyList property.
     * 
     * @return possible object is {@link PropertyList }
     * 
     */
    public PropertyList getPropertyList() {
      return propertyList;
    }

    /**
     * Sets the value of the propertyList property.
     * 
     * @param value allowed object is {@link PropertyList }
     * 
     */
    public void setPropertyList(PropertyList value) {
      this.propertyList = value;
    }

    public boolean isSetPropertyList() {
      return (this.propertyList != null);
    }

  }

}
