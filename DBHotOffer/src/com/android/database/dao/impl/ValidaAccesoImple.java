package com.android.database.dao.impl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;

import cl.hotoffer.business.validador.ValidaObject;
import cl.hotoffer.exception.BusinessException;

import com.android.database.dao.ValidaAcceso;
import com.android.database.mysql.Conector;
import com.android.model.Usuario;

public class ValidaAccesoImple implements ValidaAcceso {

	private static final Logger LOGGER = Logger
			.getLogger(ValidaAccesoImple.class);

	@Override
	public boolean validaAcceso(Usuario usuario) throws BusinessException,
			SQLException {

		CallableStatement call = null;
		try {
			String procedure = "{call sp_validaUsuario(?,?,?)}";
			LOGGER.info("CALL PROCEDURE sp_validaUsuario(?,?,?)");

			call = Conector.getInstance().getConnection()
					.prepareCall(procedure);
			Conector.getInstance().getConnection().setAutoCommit(false);
			call.setString(1, usuario.getNombre());
			call.setString(2, usuario.getPassword());
			call.registerOutParameter(3, Types.BOOLEAN);

			new ValidaObject().validate(usuario);

			call.execute();

			return call.getBoolean(3);

		} catch (SQLException e) {
			LOGGER.error("Expcetion: ", e);
			Conector.getInstance().getConnection().rollback();
			throw new BusinessException(e);
		} finally {
			Conector.getInstance().getClose();
		}

	}
}
