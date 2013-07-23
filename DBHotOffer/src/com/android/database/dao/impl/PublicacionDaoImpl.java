package com.android.database.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import cl.hotoffer.exception.PublicacionException;

import com.android.database.conector.ConnectionFactory;
import com.android.database.dao.PublicacionDAO;
import com.android.model.Publicacion;

/**
 * Clase implementadora de Interfaces PublicacionDAO
 * 
 * @author César Patricio Araya Acosta
 * 
 */
public class PublicacionDaoImpl implements PublicacionDAO {

	private static final Logger LOGGER = Logger
			.getLogger(PublicacionDaoImpl.class);
	private SqlSessionFactory sqlSessionFactory = null;

	public PublicacionDaoImpl() {
		sqlSessionFactory = ConnectionFactory.getInstance()
				.getSqlSessionFactory();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacion> getPublicacion() throws PublicacionException {

		LOGGER.info("OBTENER PUBLICACIONES ");
		List<Publicacion> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {

			list = session.selectList("Publicacion.getPublicaciones");
		} catch (Exception e) {
			throw new PublicacionException("EXCEPTION :", e);
		} finally {
			LOGGER.info("CONEXION CERRADA");
			session.close();
		}

		return list;
	}

	@Override
	public void guardarPublicacion(Publicacion publicacion)
			throws PublicacionException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			session.insert("Publicacion.guardarPublicacion", publicacion);
		} catch (Exception e) {
			LOGGER.info("EXCEPCTION :" + e);
			throw new PublicacionException(e);
		} finally {
			LOGGER.info("CONEXION CERRADA");
			session.close();
		}

	}

}
