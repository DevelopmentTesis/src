package com.android.database.dao;

import java.util.List;

import cl.hotoffer.exception.PublicacionException;

import com.android.model.Publicacion;

public interface PublicacionDAO {

	public List<Publicacion> getPublicacion() throws PublicacionException;

	public void guardarPublicacion(Publicacion publicacion)
			throws PublicacionException;

}
