package com.android.database.dao;

import cl.hotoffer.exception.ValidaAccesoException;

import com.android.model.Usuario;

public interface ValidaAcceso {

	boolean validaAcceso(Usuario usuario) throws ValidaAccesoException;

}
