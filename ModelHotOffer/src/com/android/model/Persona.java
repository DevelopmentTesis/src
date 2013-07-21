//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2013.07.21 a las 06:19:49 PM CLT 
//

package com.android.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para Persona complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Persona">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sexo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pais" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ciudad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Usuario" type="{http://cl.hotoffer/hotoffer}Usuario"/>
 *         &lt;element name="tipoUsuario">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Persona", propOrder = { "nombre", "apellido",
		"fechaNacimiento", "sexo", "pais", "ciudad", "usuario", "tipoUsuario" })
@XmlRootElement(name = "Persona")
public class Persona {

	@XmlElement(required = true)
	protected String nombre;
	@XmlElement(required = true)
	protected String apellido;
	@XmlElement(required = true)
	protected String fechaNacimiento;
	@XmlElement(required = true)
	protected String sexo;
	protected int pais;
	protected int ciudad;
	@XmlElement(name = "Usuario", required = true)
	protected Usuario usuario;
	protected int tipoUsuario;

	/**
	 * Obtiene el valor de la propiedad nombre.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Define el valor de la propiedad nombre.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}

	/**
	 * Obtiene el valor de la propiedad apellido.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Define el valor de la propiedad apellido.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setApellido(String value) {
		this.apellido = value;
	}

	/**
	 * Obtiene el valor de la propiedad fechaNacimiento.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Define el valor de la propiedad fechaNacimiento.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFechaNacimiento(String value) {
		this.fechaNacimiento = value;
	}

	/**
	 * Obtiene el valor de la propiedad sexo.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Define el valor de la propiedad sexo.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSexo(String value) {
		this.sexo = value;
	}

	/**
	 * Obtiene el valor de la propiedad pais.
	 * 
	 */
	public int getPais() {
		return pais;
	}

	/**
	 * Define el valor de la propiedad pais.
	 * 
	 */
	public void setPais(int value) {
		this.pais = value;
	}

	/**
	 * Obtiene el valor de la propiedad ciudad.
	 * 
	 */
	public int getCiudad() {
		return ciudad;
	}

	/**
	 * Define el valor de la propiedad ciudad.
	 * 
	 */
	public void setCiudad(int value) {
		this.ciudad = value;
	}

	/**
	 * Obtiene el valor de la propiedad usuario.
	 * 
	 * @return possible object is {@link Usuario }
	 * 
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Define el valor de la propiedad usuario.
	 * 
	 * @param value
	 *            allowed object is {@link Usuario }
	 * 
	 */
	public void setUsuario(Usuario value) {
		this.usuario = value;
	}

	/**
	 * Obtiene el valor de la propiedad tipoUsuario.
	 * 
	 */
	public int getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * Define el valor de la propiedad tipoUsuario.
	 * 
	 */
	public void setTipoUsuario(int value) {
		this.tipoUsuario = value;
	}

}
