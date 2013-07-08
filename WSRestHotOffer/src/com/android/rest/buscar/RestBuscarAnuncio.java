package com.android.rest.buscar;

import com.android.model.Publicacion;
import com.android.model.TipoPublicacion;

public interface RestBuscarAnuncio {

	public Publicacion buscarAnuncio(TipoPublicacion tipoPublicacion);

}
