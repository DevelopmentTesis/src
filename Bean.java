/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.jsf.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cesar
 */
@ManagedBean (name = "bean")
@SessionScoped
public class Bean {
    
    private Persona persona;
    private List<Persona> listaPersona = new ArrayList<Persona>();
   
    
    public Bean() {
       
        for (int i = 0; i < 10; i++) {
           persona = new Persona();     
           persona.setNombre("Daisy" + i);
           persona.setApellido("Zambrano");
           persona.setEdad(26);
           persona.setDireccion("Herrera");
       
         listaPersona.add(persona);
        }
       
    }
    
    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

        
}
