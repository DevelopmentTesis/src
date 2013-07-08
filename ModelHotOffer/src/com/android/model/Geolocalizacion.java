//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2013.07.07 a las 09:21:30 PM CLT 
//


package com.android.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Geolocalizacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Geolocalizacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cordLatitud" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cordLonguitud" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlRootElement
public class Geolocalizacion {

    protected int cordLatitud;
    protected int cordLonguitud;

    /**
     * Obtiene el valor de la propiedad cordLatitud.
     * 
     */
    public int getCordLatitud() {
        return cordLatitud;
    }

    /**
     * Define el valor de la propiedad cordLatitud.
     * 
     */
    public void setCordLatitud(int value) {
        this.cordLatitud = value;
    }

    /**
     * Obtiene el valor de la propiedad cordLonguitud.
     * 
     */
    public int getCordLonguitud() {
        return cordLonguitud;
    }

    /**
     * Define el valor de la propiedad cordLonguitud.
     * 
     */
    public void setCordLonguitud(int value) {
        this.cordLonguitud = value;
    }

}
