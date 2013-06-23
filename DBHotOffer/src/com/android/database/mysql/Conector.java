package com.android.database.mysql;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

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

	public Connection getConnection() throws Exception {

		try {
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup(JDNI);
			con = dataSource.getConnection();

		} catch (Exception e) {
			throw e;
		}

		return con;
	}

	private Conector() {

	}
}
