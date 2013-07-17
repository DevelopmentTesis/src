package com.android.rest.acceso;

import org.apache.log4j.Logger;

import cl.hotoffer.exception.ValidaAccesoException;

import com.android.database.dao.UsuarioDAO;
import com.android.database.dao.ValidaAcceso;
import com.android.model.Usuario;

public class RestValidaAccesoImple implements RestValidaAcceso {

	private static final Logger LOGGER = Logger
			.getLogger(RestValidaAccesoImple.class);

	private ValidaAcceso acceso = new UsuarioDAO();

	@Override
	public boolean validaAcceso(String nombre, String password)
			throws ValidaAccesoException {

		LOGGER.info("[::CALL WSRestValidaAcceso::]");

		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(password);

		return acceso.validaAcceso(usuario);
	}
}
