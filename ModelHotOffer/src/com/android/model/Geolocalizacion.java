//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.28 at 10:53:33 PM CLT 
//


package com.android.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Geolocalizacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Geolocalizacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cordLatitud" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cordLonguitud" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Geolocalizacion", propOrder = {
    "cordLatitud",
    "cordLonguitud"
})
public class Geolocalizacion {

    @XmlElement(required = true)
    protected String cordLatitud;
    @XmlElement(required = true)
    protected String cordLonguitud;

    /**
     * Gets the value of the cordLatitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCordLatitud() {
        return cordLatitud;
    }

    /**
     * Sets the value of the cordLatitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCordLatitud(String value) {
        this.cordLatitud = value;
    }

    /**
     * Gets the value of the cordLonguitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCordLonguitud() {
        return cordLonguitud;
    }

    /**
     * Sets the value of the cordLonguitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCordLonguitud(String value) {
        this.cordLonguitud = value;
    }

}
