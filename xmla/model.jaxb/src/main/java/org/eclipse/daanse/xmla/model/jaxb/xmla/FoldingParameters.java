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

import java.math.BigInteger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for FoldingParameters complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="FoldingParameters"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="FoldIndex" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="FoldCount" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="FoldMaxCases" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="FoldTargetAttribute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FoldingParameters", propOrder = {

})
public class FoldingParameters {

  @XmlElement(name = "FoldIndex", required = true)
  protected BigInteger foldIndex;
  @XmlElement(name = "FoldCount", required = true)
  protected BigInteger foldCount;
  @XmlElement(name = "FoldMaxCases")
  protected Long foldMaxCases;
  @XmlElement(name = "FoldTargetAttribute")
  protected String foldTargetAttribute;

  /**
   * Gets the value of the foldIndex property.
   * 
   * @return possible object is {@link BigInteger }
   * 
   */
  public BigInteger getFoldIndex() {
    return foldIndex;
  }

  /**
   * Sets the value of the foldIndex property.
   * 
   * @param value allowed object is {@link BigInteger }
   * 
   */
  public void setFoldIndex(BigInteger value) {
    this.foldIndex = value;
  }

  public boolean isSetFoldIndex() {
    return (this.foldIndex != null);
  }

  /**
   * Gets the value of the foldCount property.
   * 
   * @return possible object is {@link BigInteger }
   * 
   */
  public BigInteger getFoldCount() {
    return foldCount;
  }

  /**
   * Sets the value of the foldCount property.
   * 
   * @param value allowed object is {@link BigInteger }
   * 
   */
  public void setFoldCount(BigInteger value) {
    this.foldCount = value;
  }

  public boolean isSetFoldCount() {
    return (this.foldCount != null);
  }

  /**
   * Gets the value of the foldMaxCases property.
   * 
   * @return possible object is {@link Long }
   * 
   */
  public Long getFoldMaxCases() {
    return foldMaxCases;
  }

  /**
   * Sets the value of the foldMaxCases property.
   * 
   * @param value allowed object is {@link Long }
   * 
   */
  public void setFoldMaxCases(Long value) {
    this.foldMaxCases = value;
  }

  public boolean isSetFoldMaxCases() {
    return (this.foldMaxCases != null);
  }

  /**
   * Gets the value of the foldTargetAttribute property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getFoldTargetAttribute() {
    return foldTargetAttribute;
  }

  /**
   * Sets the value of the foldTargetAttribute property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setFoldTargetAttribute(String value) {
    this.foldTargetAttribute = value;
  }

  public boolean isSetFoldTargetAttribute() {
    return (this.foldTargetAttribute != null);
  }

}
