package com.android.rest.acceso;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import cl.hotoffer.exception.BusinessException;

import com.android.database.dao.ValidaAcceso;
import com.android.database.dao.impl.ValidaAccesoImple;
import com.android.model.Usuario;

public class RestValidaAccesoImple implements RestValidaAcceso {

	private static final Logger LOGGER = Logger
			.getLogger(RestValidaAccesoImple.class);

	private ValidaAcceso acceso = new ValidaAccesoImple();

	@Override
	public boolean validaAcceso(String nombre, String password)
			throws SQLException, BusinessException {

		LOGGER.info("[::CALL WSRestValidaAcceso::]");

		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(password);

		return acceso.validaAcceso(usuario);
	}
}
