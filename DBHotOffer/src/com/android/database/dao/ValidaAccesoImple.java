package com.android.database.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import com.android.database.exception.HotOfferSQLException;
import com.android.database.exception.ValidaAccesoException;
import com.android.database.mysql.Conector;
import com.android.model.Usuario;

public class ValidaAccesoImple implements ValidaAcceso {

	@Override
	public Integer validaAcceso(Usuario usuario) throws ValidaAccesoException {

		ResultSet resultSet;
		Integer registro = null;
		try {

			Statement statement = Conector.getInstance().getConnection()
					.createStatement();

			resultSet = statement
					.executeQuery("SELECT 1 FROM USUARIO WHERE NOMBRE = '"
							+ usuario.getNombre() + "' and PASSWORD='"
							+ usuario.getPassword() + "'");

			while (resultSet.next()) {
				registro = resultSet.getInt(1);
			}
			return registro;
		} catch (Exception e) {
			throw new ValidaAccesoException(e.getMessage(), e);
		} finally {
			try {
				Conector.getInstance().getClose();
			} catch (HotOfferSQLException e) {
				throw new ValidaAccesoException(e);
			}
		}
	}
}
