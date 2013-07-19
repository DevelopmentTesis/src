//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2013.07.18 a las 07:23:33 PM CLT 
//


package com.android.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Publicacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Publicacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idTipoPublicacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idUsuario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="comentario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Publicacion", propOrder = {
    "idTipoPublicacion",
    "idUsuario",
    "comentario",
    "precio",
    "tienda"
})
@XmlRootElement(name = "Publicacion")
public class Publicacion {

    protected int idTipoPublicacion;
    protected int idUsuario;
    @XmlElement(required = true)
    protected String comentario;
    @XmlElement(required = true)
    protected String precio;
    protected String tienda;

    /**
     * Obtiene el valor de la propiedad idTipoPublicacion.
     * 
     */
    public int getIdTipoPublicacion() {
        return idTipoPublicacion;
    }

    /**
     * Define el valor de la propiedad idTipoPublicacion.
     * 
     */
    public void setIdTipoPublicacion(int value) {
        this.idTipoPublicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuario.
     * 
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define el valor de la propiedad idUsuario.
     * 
     */
    public void setIdUsuario(int value) {
        this.idUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad comentario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Define el valor de la propiedad comentario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComentario(String value) {
        this.comentario = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrecio(String value) {
        this.precio = value;
    }

    /**
     * Obtiene el valor de la propiedad tienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTienda() {
        return tienda;
    }

    /**
     * Define el valor de la propiedad tienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTienda(String value) {
        this.tienda = value;
    }

}
