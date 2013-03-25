/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.jsf.bean;

import java.io.Serializable;

/**
 *
 * @author cesar
 */
public class Persona implements Serializable{
    
    private String nombre;
    private String apellido;
    private Integer edad;
    private String direccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
