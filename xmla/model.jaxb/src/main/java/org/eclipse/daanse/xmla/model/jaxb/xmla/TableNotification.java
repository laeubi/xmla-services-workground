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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for TableNotification complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="TableNotification"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="DbTableName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DbSchemaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TableNotification", propOrder = {

})
public class TableNotification {

  @XmlElement(name = "DbTableName", required = true)
  protected String dbTableName;
  @XmlElement(name = "DbSchemaName")
  protected String dbSchemaName;

  /**
   * Gets the value of the dbTableName property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getDbTableName() {
    return dbTableName;
  }

  /**
   * Sets the value of the dbTableName property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setDbTableName(String value) {
    this.dbTableName = value;
  }

  public boolean isSetDbTableName() {
    return (this.dbTableName != null);
  }

  /**
   * Gets the value of the dbSchemaName property.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getDbSchemaName() {
    return dbSchemaName;
  }

  /**
   * Sets the value of the dbSchemaName property.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setDbSchemaName(String value) {
    this.dbSchemaName = value;
  }

  public boolean isSetDbSchemaName() {
    return (this.dbSchemaName != null);
  }

}
