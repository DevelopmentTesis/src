package com.android.database.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import cl.hotoffer.exception.HotOfferSQLException;

public class Conector {

	private static final Logger LOGGER = Logger.getLogger(Conector.class);
	private static final String JDNI = "java:jboss/datasources/HotOffer";
	private static Conector conector = null;
	private static Connection con;

	public static Conector getInstance() {
		synchronized (Conector.class) {
			if (conector == null) {
				conector = new Conector();
			}
		}
		return conector;
	}

	public Connection getConnection() {

		try {

			LOGGER.info("DATASOURCE : " + JDNI);

			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup(JDNI);

			con = dataSource.getConnection();

		} catch (SQLException e) {
			LOGGER.error("SQLException : " + e);
		} catch (NamingException e) {
			LOGGER.error("NamingException  : " + e);
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
