package com.android.rest.acceso;

import org.apache.log4j.Logger;

import cl.hotoffer.business.validador.ValidaObject;
import cl.hotoffer.exception.BusinessException;
import cl.hotoffer.exception.UsuarioException;

import com.android.database.dao.UsuarioDAO;
import com.android.database.dao.impl.UsuarioDaoImpl;
import com.android.model.Persona;
import com.android.model.Usuario;

public class RestServiceImpl implements RestService {

	private static final Logger LOGGER = Logger
			.getLogger(RestServiceImpl.class);

	private UsuarioDAO acceso = new UsuarioDaoImpl();

	@Override
	public boolean validaAcceso(String nombre, String password)
			throws UsuarioException {

		LOGGER.info("[::CALL WSRestValidaAcceso::]");

		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(password);

		return acceso.validaAcceso(usuario);
	}

	public String crearAcceso(String nombre, String apellido, String fechaN,
			String sexo, Integer pais, Integer ciudad, String user, String pass)
			throws UsuarioException, BusinessException {

		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setFechaNacimiento(fechaN);
		persona.setSexo(sexo);
		persona.setPais(pais);	
		persona.setCiudad(ciudad);		
		persona.setTipoUsuario(0);
		
		Usuario usuario = new Usuario();
		usuario.setNombre(user);
		usuario.setPassword(pass);

		persona.setUsuario(usuario);

		new ValidaObject().validate(persona);

		acceso.insert(persona);

		return null;
	}

}
