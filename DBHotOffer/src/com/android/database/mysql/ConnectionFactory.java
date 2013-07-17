package com.android.database.mysql;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

/**
 * MyBatis Connection Factory, which reads the configuration data from a XML
 * file.
 * 
 * @author Loiane Groner http://loianegroner.com (English) http://loiane.com
 *         (Portuguese)
 */
public class ConnectionFactory {

	private static SqlSessionFactory sqlSessionFactory;
	private static final Logger LOGGER = Logger
			.getLogger(ConnectionFactory.class);

	public static SqlSessionFactory getSqlSessionFactory() {

		try {

			String resource = "ibatisConfig.xml";
			LOGGER.info("RESOURCE :" + resource);
			Reader reader = Resources.getResourceAsReader(resource);

			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder()
						.build(reader);
			}
		}

		catch (FileNotFoundException e) {
			LOGGER.info("FileNotFoundException :" + e);
		} catch (IOException io) {
			LOGGER.info("IOException :" + io);
		}

		return sqlSessionFactory;
	}

}
