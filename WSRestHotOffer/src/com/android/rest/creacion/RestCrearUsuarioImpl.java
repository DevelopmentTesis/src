package com.android.rest.creacion;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import cl.hotoffer.exception.BusinessException;

public class RestCrearUsuarioImpl implements RestCrearUsuario {

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/acceso")
	public double crearUsuario(@FormParam("form") String form)
			throws BusinessException {

		return 0;
	}

}
