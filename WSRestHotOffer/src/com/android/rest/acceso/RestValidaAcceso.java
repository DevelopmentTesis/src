package com.android.rest.acceso;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import cl.hotoffer.exception.ValidaAccesoException;

@Path("/valida")
public interface RestValidaAcceso {

	@GET
	@Path("/acceso")
	boolean validaAcceso(@QueryParam("nombre") String nombre,
			@QueryParam("password") String password)
			throws ValidaAccesoException;
}
