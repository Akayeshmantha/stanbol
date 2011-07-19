/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.3-hudson-jaxb-ri-2.2.3-3- 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.17 at 10:53:39 AM EEST 
//


package org.apache.stanbol.cmsadapter.servicesapi.model.web;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{web.model.servicesapi.cmsadapter.stanbol.apache.org}localname"/>
 *         &lt;element ref="{web.model.servicesapi.cmsadapter.stanbol.apache.org}sourceObjectTypeRef"/>
 *         &lt;element ref="{web.model.servicesapi.cmsadapter.stanbol.apache.org}containerObjectRef" minOccurs="0"/>
 *         &lt;element ref="{web.model.servicesapi.cmsadapter.stanbol.apache.org}value" maxOccurs="unbounded"/>
 *         &lt;element ref="{web.model.servicesapi.cmsadapter.stanbol.apache.org}propertyDefinition" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "localname",
    "sourceObjectTypeRef",
    "containerObjectRef",
    "value",
    "propertyDefinition"
})
@XmlRootElement(name = "property")
public class Property {

    @XmlElement(required = true)
    protected String localname;
    @XmlElement(required = true)
    protected String sourceObjectTypeRef;
    protected String containerObjectRef;
    @XmlElement(required = true)
    protected List<String> value;
    protected PropertyDefinition propertyDefinition;

    /**
     * Gets the value of the localname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalname() {
        return localname;
    }

    /**
     * Sets the value of the localname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalname(String value) {
        this.localname = value;
    }

    /**
     * Gets the value of the sourceObjectTypeRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceObjectTypeRef() {
        return sourceObjectTypeRef;
    }

    /**
     * Sets the value of the sourceObjectTypeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceObjectTypeRef(String value) {
        this.sourceObjectTypeRef = value;
    }

    /**
     * Gets the value of the containerObjectRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContainerObjectRef() {
        return containerObjectRef;
    }

    /**
     * Sets the value of the containerObjectRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContainerObjectRef(String value) {
        this.containerObjectRef = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getValue() {
        if (value == null) {
            value = new ArrayList<String>();
        }
        return this.value;
    }

    /**
     * Gets the value of the propertyDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyDefinition }
     *     
     */
    public PropertyDefinition getPropertyDefinition() {
        return propertyDefinition;
    }

    /**
     * Sets the value of the propertyDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyDefinition }
     *     
     */
    public void setPropertyDefinition(PropertyDefinition value) {
        this.propertyDefinition = value;
    }

}
