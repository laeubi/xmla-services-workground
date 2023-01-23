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
package org.eclipse.daanse.xmla.model.jaxb.engine200;

import java.io.Serializable;
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
 *       &lt;all&gt;
 *         &lt;element name="Cube" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MeasureGroup" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MeasureName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "WarningMeasure")
public class WarningMeasure implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlElement(name = "Cube", required = true)
  protected String cube;
  @XmlElement(name = "MeasureGroup", required = true)
  protected String measureGroup;
  @XmlElement(name = "MeasureName", required = true)
  protected String measureName;

  /**
   * Gets the value of the cube property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getCube() {
    return cube;
  }

  /**
   * Sets the value of the cube property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setCube(String value) {
    this.cube = value;
  }

  public boolean isSetCube() {
    return (this.cube != null);
  }

  /**
   * Gets the value of the measureGroup property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getMeasureGroup() {
    return measureGroup;
  }

  /**
   * Sets the value of the measureGroup property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setMeasureGroup(String value) {
    this.measureGroup = value;
  }

  public boolean isSetMeasureGroup() {
    return (this.measureGroup != null);
  }

  /**
   * Gets the value of the measureName property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getMeasureName() {
    return measureName;
  }

  /**
   * Sets the value of the measureName property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setMeasureName(String value) {
    this.measureName = value;
  }

  public boolean isSetMeasureName() {
    return (this.measureName != null);
  }

}
