package com.android.rest.creacion;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import cl.hotoffer.exception.BusinessException;

@Path("/creacion")
public interface RestCrearUsuario {

	@POST
	@Consumes({ "application/json" })
	@Path("/acceso")
	double crearUsuario(@QueryParam("password") String password)
			throws BusinessException;

}