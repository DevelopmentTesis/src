package com.android.database.dao;

import com.android.database.exception.ValidaAccesoException;
import com.android.model.Usuario;

public interface ValidaAcceso {

	Integer validaAcceso(Usuario usuario) throws ValidaAccesoException;

}
