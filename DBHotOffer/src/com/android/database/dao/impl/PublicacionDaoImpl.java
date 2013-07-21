package com.android.database.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import cl.hotoffer.exception.BusinessException;

import com.android.database.conector.ConnectionFactory;
import com.android.database.dao.PublicacionDAO;
import com.android.model.Publicacion;

public class PublicacionDaoImpl implements PublicacionDAO {

	private static final Logger LOGGER = Logger
			.getLogger(PublicacionDaoImpl.class);
	private SqlSessionFactory sqlSessionFactory = null;

	public PublicacionDaoImpl() {
		sqlSessionFactory = ConnectionFactory.getInstance()
				.getSqlSessionFactory();
	}

	@Override
	public List<Publicacion> getPublicacion() throws BusinessException {

		SqlSession session = sqlSessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<Publicacion> list = session
				.selectList("Publicacion.getPublicaciones");

		return list;
	}

	@Override
	public void guardarPublicacion(Publicacion publicacion)
			throws BusinessException {
		SqlSession session = sqlSessionFactory.openSession();

		session.insert("Publicacion.guardarPublicacion", publicacion);

	}

}
