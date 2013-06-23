package com.android.rest.acceso;

import com.android.database.dao.ValidaAcceso;
import com.android.database.dao.ValidaAccesoImple;
import com.android.database.exception.ValidaAccesoException;
import com.android.model.Usuario;

public class RestValidaAccesoImple implements RestValidaAcceso {

	@Override
	public Integer validaAcceso(String nombre, String password)
			throws ValidaAccesoException {

		ValidaAcceso acceso = new ValidaAccesoImple();

		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(password);

		return acceso.validaAcceso(usuario);
	}

	@Override
	public String validaAcceso() throws ValidaAccesoException {
		return "TEST";

	}

}
