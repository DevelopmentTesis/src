package com.android.database.dao;

import java.util.List;

import cl.hotoffer.exception.BusinessException;

import com.android.database.dao.to.PublicacionTO;
import com.android.model.Publicacion;

public interface PublicacionDAO {

	public void publicar(Publicacion publicacion) throws BusinessException;

	public List<Publicacion> getPublicacion() throws BusinessException;

}
