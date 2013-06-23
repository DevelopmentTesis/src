package com.android.rest.acceso;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.android.database.exception.ValidaAccesoException;

@Path("/valida")
public interface RestValidaAcceso {

	@GET
	@Path("/acceso")
	Integer validaAcceso(@QueryParam("nombre") String nombre,
			@QueryParam("password") String password)
			throws ValidaAccesoException;

	@GET
	@Path("/acceso")
	String validaAcceso() throws ValidaAccesoException;

}
