package com.android.rest.acceso;

import java.util.List;

import org.apache.log4j.Logger;

import cl.hotoffer.exception.BusinessException;
import cl.hotoffer.exception.PublicacionException;
import cl.hotoffer.exception.UsuarioException;

import com.android.database.dao.PublicacionDAO;
import com.android.database.dao.UsuarioDAO;
import com.android.database.dao.impl.PublicacionDaoImpl;
import com.android.database.dao.impl.UsuarioDaoImpl;
import com.android.model.Persona;
import com.android.model.Publicacion;
import com.android.model.TipoPublicacion;
import com.android.model.Usuario;

public class RestServiceImpl implements RestService {

	private static final Logger LOGGER = Logger
			.getLogger(RestServiceImpl.class);

	private UsuarioDAO acceso = new UsuarioDaoImpl();

	public boolean validaAcceso(String nombre, String password)
			throws UsuarioException, BusinessException {

		LOGGER.info("[::CALL WSRestValidaAcceso::]");
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(password);

		return acceso.validaAcceso(usuario);
	}

	public void crearAcceso(String nombre, String apellido, String fechaN,
			String sexo, Integer pais, Integer ciudad, String user, String pass)
			throws UsuarioException, BusinessException {

		LOGGER.info("CREAR PERSONA");
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setFechaNacimiento(fechaN);
		persona.setSexo(sexo);
		persona.setPais(pais);
		persona.setCiudad(ciudad);
		persona.setTipoUsuario(1);
		Usuario usuario = new Usuario();
		usuario.setNombre(user);
		usuario.setPassword(pass);

		persona.setUsuario(usuario);

		acceso.insert(persona);
	}

	public List<Publicacion> getPublicaciones() throws BusinessException,
			PublicacionException {

		PublicacionDAO dao = new PublicacionDaoImpl();

		return dao.getPublicacion();
	}

	public List<Publicacion> buscarPublicaciones(int id)
			throws BusinessException, PublicacionException {
		PublicacionDAO dao = new PublicacionDaoImpl();
		return dao.buscarPublicaciones(id);
	}

	@Override
	public List<Usuario> buscarUsuario(String nombre) throws UsuarioException,
			BusinessException {

		UsuarioDAO dao = new UsuarioDaoImpl();
		return dao.selectByName(nombre);
	}

	public List<TipoPublicacion> getTipoPublicaciones()
			throws BusinessException, PublicacionException {
		PublicacionDAO dao = new PublicacionDaoImpl();
		return dao.tiposPublicaciones();
	}

}
