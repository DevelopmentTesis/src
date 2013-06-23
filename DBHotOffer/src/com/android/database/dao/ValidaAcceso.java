package com.android.database.dao;

import java.sql.SQLException;

import com.android.model.Usuario;

public interface ValidaAcceso {

	boolean validaAcceso(Usuario usuario) throws SQLException;

}
