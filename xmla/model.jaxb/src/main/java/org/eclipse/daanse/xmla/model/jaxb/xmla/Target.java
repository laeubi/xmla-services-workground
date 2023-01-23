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
import jakarta.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{urn:schemas-microsoft-com:xml-analysis}parameter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{urn:schemas-microsoft-com:xml-analysis}objectNames"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "parameter" })
@XmlRootElement(name = "target")
public class Target {

  @XmlElement(namespace = "urn:schemas-microsoft-com:xml-analysis")
  protected List<Parameter> parameter;
  @XmlAttribute(name = "module")
  protected String module;
  @XmlAttribute(name = "package", required = true)
  protected String _package;
  @XmlAttribute(name = "name", required = true)
  protected String name;

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
   * Objects of the following type(s) are allowed in the list {@link Parameter }
   * 
   * 
   */
  public List<Parameter> getParameter() {
    if (parameter == null) {
      parameter = new ArrayList<Parameter>();
    }
    return this.parameter;
  }

  public boolean isSetParameter() {
    return ((this.parameter != null) && (!this.parameter.isEmpty()));
  }

  public void unsetParameter() {
    this.parameter = null;
  }

  /**
   * Gets the value of the module property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getModule() {
    return module;
  }

  /**
   * Sets the value of the module property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setModule(String value) {
    this.module = value;
  }

  public boolean isSetModule() {
    return (this.module != null);
  }

  /**
   * Gets the value of the package property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getPackage() {
    return _package;
  }

  /**
   * Sets the value of the package property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setPackage(String value) {
    this._package = value;
  }

  public boolean isSetPackage() {
    return (this._package != null);
  }

  /**
   * Gets the value of the name property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the name property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setName(String value) {
    this.name = value;
  }

  public boolean isSetName() {
    return (this.name != null);
  }

}
