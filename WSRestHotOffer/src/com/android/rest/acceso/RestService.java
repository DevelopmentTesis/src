package com.android.rest.acceso;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import cl.hotoffer.exception.BusinessException;
import cl.hotoffer.exception.PublicacionException;
import cl.hotoffer.exception.UsuarioException;

import com.android.model.Publicacion;

@Path("/service")
public interface RestService {

	@GET
	@Path("/valida/acceso")
	boolean validaAcceso(@QueryParam("nombre") String nombre,
			@QueryParam("password") String password) throws UsuarioException,
			BusinessException;

	@GET
	@Path("/crear/acceso")
	String crearAcceso(@QueryParam("nom") String nombre,
			@QueryParam("ape") String apellido,
			@QueryParam("fNac") String fechaN, @QueryParam("sx") String sexo,
			@QueryParam("idPais") Integer pais,
			@QueryParam("idCiudad") Integer ciudad,
			@QueryParam("user") String user, @QueryParam("pass") String pass)
			throws UsuarioException, BusinessException;

	@GET
	@Produces("application/json")
	@Path("/publicacion/obtener")
	List<Publicacion> getPublicaciones() throws BusinessException,
			PublicacionException;

}
