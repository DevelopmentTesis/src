package com.android.database.dao;

import java.util.List;

import cl.hotoffer.exception.PublicacionException;

import com.android.model.Publicacion;

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
	 * Metodo que permite guardar publicacion en BD
	 * 
	 * @param publicacion
	 * @throws PublicacionException
	 */
	public void guardarPublicacion(Publicacion publicacion)
			throws PublicacionException;

}
