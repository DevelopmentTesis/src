package com.android.rest.acceso;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.android.database.dao.ValidaAcceso;
import com.android.database.dao.ValidaAccesoImple;
import com.android.database.exception.ValidaAccesoException;
import com.android.model.Usuario;

public class RestValidaAccesoImple implements RestValidaAcceso {

	private static final Logger LOGGER = Logger
			.getLogger(RestValidaAccesoImple.class);

	@Override
	public boolean validaAcceso(String nombre, String password)
			throws ValidaAccesoException, SQLException {

		LOGGER.info("[::CALL WSRestValidaAcceso::]");

		ValidaAcceso acceso = new ValidaAccesoImple();

		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(password);

		return acceso.validaAcceso(usuario);
	}
}
