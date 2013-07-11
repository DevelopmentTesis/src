package com.android.rest.creacion;

import javax.ws.rs.FormParam;

import cl.hotoffer.exception.BusinessException;

import com.android.database.dao.CrearUsuario;
import com.android.database.dao.impl.CrearUsuarioImpl;
import com.android.model.Persona;

public class RestCrearUsuarioImpl implements RestCrearUsuario {

	private CrearUsuario crearUsuario = new CrearUsuarioImpl();

	public double crearUsuario(@FormParam("form") Persona form)
			throws BusinessException {

		crearUsuario.crearUsuario(form);

		return 0;
	}

}
