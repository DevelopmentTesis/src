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

import com.android.model.Comentario;
import com.android.model.Publicacion;
import com.android.model.TipoPublicacion;
import com.android.model.Usuario;

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
	Integer validaAcceso(@QueryParam("nombre") String nombre,
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
	Integer crearAcceso(@QueryParam("nom") String nombre,
			@QueryParam("ape") String apellido,
			@QueryParam("fNac") String fechaN, @QueryParam("sx") String sexo,
			@QueryParam("idPais") Integer pais,
			@QueryParam("idCiudad") Integer ciudad,
			@QueryParam("user") String user, @QueryParam("pass") String pass)
			throws UsuarioException, BusinessException;

	/**
	 * Buscar usuario según nombre
	 * 
	 * @return
	 * @throws UsuarioException
	 * @throws BusinessException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/usuario")
	List<Usuario> buscarUsuario(@QueryParam("nombre") String nombre)
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

	/**
	 * Metodo que permite obtener tipo de publicaciones del sistema
	 * 
	 * @return List<Publicacion> Estructura JSON
	 * @throws BusinessException
	 * @throws PublicacionException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/publicacion/tipo")
	List<TipoPublicacion> getTipoPublicaciones() throws BusinessException,
			PublicacionException;

	/**
	 * 
	 * @return
	 * @throws BusinessException
	 * @throws PublicacionException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/publicacion/buscar")
	List<Publicacion> buscarPublicaciones(@QueryParam("id") int id)
			throws BusinessException, PublicacionException;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/publicacion/comentarios")
	List<Comentario> comentariosPublicacion(@QueryParam("id") int id)
			throws BusinessException, PublicacionException;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/publicacion/comentar")
	boolean comentarPublicacion(@QueryParam("idPub") String idPub,
			@QueryParam("comentario") String comentario,
			@QueryParam("idUser") String idUser) throws BusinessException,
			PublicacionException;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/publicacion/publicar")
	boolean publicar(@QueryParam("idUsuario") Integer idUsuario,
			@QueryParam("tipoPub") Integer tipoPub,
			@QueryParam("latitud") String latitud,
			@QueryParam("longitud") String longitud,
			@QueryParam("precio") String precio,
			@QueryParam("tienda") String tienda,
			@QueryParam("comentario") String comentario)
			throws BusinessException, PublicacionException;

}
