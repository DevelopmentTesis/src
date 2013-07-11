package com.android.database.dao;

import cl.hotoffer.exception.BusinessException;

import com.android.model.Publicacion;
import com.android.model.TipoPublicacion;

public interface BuscarAnuncio {

	public Publicacion buscar(TipoPublicacion tipoPublicacion)
			throws BusinessException;

}
