package com.android.database.dao;

import java.util.List;

import cl.hotoffer.exception.BusinessException;

import com.android.model.Publicacion;

public interface PublicacionDAO {

	public List<Publicacion> getPublicacion() throws BusinessException;

	public void guardarPublicacion(Publicacion publicacion)
			throws BusinessException;

}
