package com.android.database.dao;

import com.android.model.Publicacion;

import cl.hotoffer.exception.BusinessException;

public interface PublicarAnuncio {

	
	public void publicar(Publicacion publicacion)throws BusinessException;
	
	
}
