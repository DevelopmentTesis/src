package com.android.database.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;

import com.android.database.mysql.Conector;
import com.android.model.Usuario;

public class ValidaAccesoImple implements ValidaAcceso {

	private static final Logger LOGGER = Logger
			.getLogger(ValidaAccesoImple.class);

	@Override
	public boolean validaAcceso(Usuario usuario) throws SQLException {

		Connection con = Conector.getInstance().getConnection();
		CallableStatement call = null;
		try {
			String procedure = "{call sp_validaUsuario(?,?,?)}";
			LOGGER.info("CALL PROCEDURE sp_validaUsuario(?,?,?)");
			call = con.prepareCall(procedure);
			con.setAutoCommit(false);
			call.setString(1, usuario.getNombre());
			call.setString(2, usuario.getPassword());
			call.registerOutParameter(3, Types.BOOLEAN);

			System.out.println("USUARIO: " + usuario.getNombre());
			System.out.println("PASSWORD: " + usuario.getPassword());

			call.execute();

			return call.getBoolean(3);

		} catch (Exception e) {
			LOGGER.error("Expcetion: ", e);
			con.rollback();
		} finally {
			LOGGER.error("CIERRE DE CONEXION BD");
			con.close();
		}
		return false;
	}
}
