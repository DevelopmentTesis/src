//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2013.07.18 a las 07:23:33 PM CLT 
//


package cl.hotoffer.business.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.android.model.Geolocalizacion;
import com.android.model.Persona;
import com.android.model.Publicacion;
import com.android.model.TipoPublicacion;
import com.android.model.Usuario;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.android.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Persona_QNAME = new QName("http://cl.hotoffer/hotoffer", "Persona");
    private final static QName _Publicacion_QNAME = new QName("http://cl.hotoffer/hotoffer", "Publicacion");
    private final static QName _Geolocalizacion_QNAME = new QName("http://cl.hotoffer/hotoffer", "Geolocalizacion");
    private final static QName _Usuario_QNAME = new QName("http://cl.hotoffer/hotoffer", "Usuario");
    private final static QName _TipoPublicacion_QNAME = new QName("http://cl.hotoffer/hotoffer", "TipoPublicacion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.android.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TipoPublicacion }
     * 
     */
    public TipoPublicacion createTipoPublicacion() {
        return new TipoPublicacion();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link Geolocalizacion }
     * 
     */
    public Geolocalizacion createGeolocalizacion() {
        return new Geolocalizacion();
    }

    /**
     * Create an instance of {@link Publicacion }
     * 
     */
    public Publicacion createPublicacion() {
        return new Publicacion();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Persona }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cl.hotoffer/hotoffer", name = "Persona")
    public JAXBElement<Persona> createPersona(Persona value) {
        return new JAXBElement<Persona>(_Persona_QNAME, Persona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Publicacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cl.hotoffer/hotoffer", name = "Publicacion")
    public JAXBElement<Publicacion> createPublicacion(Publicacion value) {
        return new JAXBElement<Publicacion>(_Publicacion_QNAME, Publicacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Geolocalizacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cl.hotoffer/hotoffer", name = "Geolocalizacion")
    public JAXBElement<Geolocalizacion> createGeolocalizacion(Geolocalizacion value) {
        return new JAXBElement<Geolocalizacion>(_Geolocalizacion_QNAME, Geolocalizacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Usuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cl.hotoffer/hotoffer", name = "Usuario")
    public JAXBElement<Usuario> createUsuario(Usuario value) {
        return new JAXBElement<Usuario>(_Usuario_QNAME, Usuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoPublicacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cl.hotoffer/hotoffer", name = "TipoPublicacion")
    public JAXBElement<TipoPublicacion> createTipoPublicacion(TipoPublicacion value) {
        return new JAXBElement<TipoPublicacion>(_TipoPublicacion_QNAME, TipoPublicacion.class, null, value);
    }

}
