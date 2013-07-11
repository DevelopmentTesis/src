package cl.hotoffer.business.validador;

import cl.hotoffer.exception.BusinessException;

import com.android.model.Persona;
import com.android.model.Usuario;

public class Test {

	/**
	 * @param args
	 * @throws BusinessException
	 */
	public static void main(String[] args) throws BusinessException {

		Persona persona = new Persona();
		
		persona.setApellido("");
		persona.setCiudad("");
		persona.setFechaNacimiento("");
		persona.setNombre("");
		persona.setPais("");
		persona.setSexo("");
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre("");
		usuario.setPassword("");
		persona.setUsuario(usuario);
		

		new ValidaObject().validate(persona);

	}

}
