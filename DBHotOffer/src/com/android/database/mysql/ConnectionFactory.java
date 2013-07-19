package com.android.database.mysql;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class ConnectionFactory {

	private static SqlSessionFactory session;
	private static final Logger LOGGER = Logger
			.getLogger(ConnectionFactory.class);

	private ConnectionFactory() {

	}

	public static ConnectionFactory getInstance() {
		synchronized (ConnectionFactory.class) {
			return new ConnectionFactory();
		}
	}

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

}
