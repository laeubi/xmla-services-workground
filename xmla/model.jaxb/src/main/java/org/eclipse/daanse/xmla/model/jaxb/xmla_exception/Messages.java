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
package org.eclipse.daanse.xmla.model.jaxb.xmla_exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Messages complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Messages"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="Warning" type="{urn:schemas-microsoft-com:xml-analysis:exception}WarningType"/&gt;
 *         &lt;element name="Error" type="{urn:schemas-microsoft-com:xml-analysis:exception}ErrorType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Messages", propOrder = { "warningOrError" })
public class Messages implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlElements({ @XmlElement(name = "Warning", type = WarningType.class),
      @XmlElement(name = "Error", type = ErrorType.class) })
  protected List<Serializable> warningOrError;

  /**
   * Gets the value of the warningOrError property.
   * 
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot.
   * Therefore any modification you make to the returned list will be present
   * inside the Jakarta XML Binding object. This is why there is not a
   * <CODE>set</CODE> method for the warningOrError property.
   * 
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getWarningOrError().add(newItem);
   * </pre>
   * 
   * 
   * <p>
   * Objects of the following type(s) are allowed in the list {@link ErrorType }
   * {@link WarningType }
   * 
   * 
   */
  public List<Serializable> getWarningOrError() {
    if (warningOrError == null) {
      warningOrError = new ArrayList<Serializable>();
    }
    return this.warningOrError;
  }

  public boolean isSetWarningOrError() {
    return ((this.warningOrError != null) && (!this.warningOrError.isEmpty()));
  }

  public void unsetWarningOrError() {
    this.warningOrError = null;
  }

}
