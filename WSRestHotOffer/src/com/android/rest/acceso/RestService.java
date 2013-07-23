package com.android.rest.acceso;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cl.hotoffer.exception.BusinessException;
import cl.hotoffer.exception.PublicacionException;
import cl.hotoffer.exception.UsuarioException;

import com.android.model.Publicacion;

/**
 * Interface RestService Expone cada metodo de los servicios Rest consumidos por
 * HotOffer Mobil
 * 
 * @author César Patricio Araya Acosta
 * 
 */
@Path("/service")
public interface RestService {
	/**
	 * Metodo que permite validar acceso de usuario a sistema HotOffer
	 * 
	 * @param nombre
	 * @param password
	 * @return boolean Estructura JSON
	 * @throws UsuarioException
	 * @throws BusinessException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/valida/acceso")
	boolean validaAcceso(@QueryParam("nombre") String nombre,
			@QueryParam("password") String password) throws UsuarioException,
			BusinessException;

	/**
	 * Metodo que permite crear acceso a sistema
	 * 
	 * @param nombre
	 * @param apellido
	 * @param fechaN
	 * @param sexo
	 * @param pais
	 * @param ciudad
	 * @param user
	 * @param pass
	 * @throws UsuarioException
	 * @throws BusinessException
	 */
	@GET
	@Path("/crear/acceso")
	void crearAcceso(@QueryParam("nom") String nombre,
			@QueryParam("ape") String apellido,
			@QueryParam("fNac") String fechaN, @QueryParam("sx") String sexo,
			@QueryParam("idPais") Integer pais,
			@QueryParam("idCiudad") Integer ciudad,
			@QueryParam("user") String user, @QueryParam("pass") String pass)
			throws UsuarioException, BusinessException;

	/**
	 * Metodo que permite obtener todas las publicaciones del sistema
	 * 
	 * @return List<Publicacion> Estructura JSON
	 * @throws BusinessException
	 * @throws PublicacionException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/publicacion/obtener")
	List<Publicacion> getPublicaciones() throws BusinessException,
			PublicacionException;

}
