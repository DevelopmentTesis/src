package com.android.database.conector;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

/**
 * Clase encargada de abrir Conexion a Base de Datos a través de Ibatis
 * 
 * @author César Patricio Araya Acosta
 * 
 */
public class ConnectionFactory {

	private static SqlSessionFactory session;
	private static final Logger LOGGER = Logger
			.getLogger(ConnectionFactory.class);

	/**
	 * 
	 * @return ConnectionFactory
	 */
	public static ConnectionFactory getInstance() {
		synchronized (ConnectionFactory.class) {
			return new ConnectionFactory();
		}
	}

	/**
	 * Metodo encargado de leer archivo ibatisConfig.xml para abrir session en
	 * base de datos
	 * 
	 * @return SqlSessionFactory
	 */
	public SqlSessionFactory getSqlSessionFactory() {

		String resource = "ibatisConfig.xml";
		LOGGER.info("RESOURCE :" + resource);
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);

			if (session == null) {
				session = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
		return session;
	}

	private ConnectionFactory() {
	}
}
