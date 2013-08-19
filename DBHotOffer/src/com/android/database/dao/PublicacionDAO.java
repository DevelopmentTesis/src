package com.android.database.dao;

import java.util.List;

import cl.hotoffer.exception.PublicacionException;

import com.android.model.Publicacion;
import com.android.model.TipoPublicacion;

/**
 * Interface PublicacionDAO, expone metodo que interactuan con la base de datos
 * 
 * @author César Patricio Araya Acosta
 * 
 */
public interface PublicacionDAO {

	/**
	 * Metodo que permite obtener publicaciones HotOffer
	 * 
	 * @return List<Publicacion>
	 * @throws PublicacionException
	 */
	public List<Publicacion> getPublicacion() throws PublicacionException;

	/**
	 * Buscar publicaciones por tipo
	 * 
	 * @param id
	 * @return
	 * @throws PublicacionException
	 */
	public List<Publicacion> buscarPublicaciones(int id)
			throws PublicacionException;

	/**
	 * Metodo que permite obtener lista de tipo de publicaciones
	 * @return
	 * @throws PublicacionException
	 */
	public List<TipoPublicacion> tiposPublicaciones()
			throws PublicacionException;

	/**
	 * Metodo que permite guardar publicacion en BD
	 * 
	 * @param publicacion
	 * @throws PublicacionException
	 */
	public void guardarPublicacion(Publicacion publicacion)
			throws PublicacionException;

}
