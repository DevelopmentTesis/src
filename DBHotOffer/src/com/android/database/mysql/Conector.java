package com.android.database.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.android.database.exception.HotOfferSQLException;

public class Conector {

	private static final String JDNI = "java:jboss/datasources/HotOffer";
	private static Conector conector = null;
	private Connection con;

	public static Conector getInstance() {
		synchronized (Conector.class) {
			if (conector == null) {
				conector = new Conector();
			}
		}
		return conector;
	}

	public Connection getConnection() throws HotOfferSQLException {

		try {
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup(JDNI);
			con = dataSource.getConnection();

		} catch (Exception e) {
			throw new HotOfferSQLException("Error en Conector", e);
		}
		return con;
	}

	public void getClose() throws HotOfferSQLException {
		try {
			con.close();
		} catch (SQLException e) {
			throw new HotOfferSQLException(e);
		}
	}

	private Conector() {

	}
}
