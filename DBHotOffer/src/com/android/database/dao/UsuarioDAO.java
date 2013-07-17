package com.android.database.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import cl.hotoffer.exception.ValidaAccesoException;

import com.android.database.mysql.ConnectionFactory;
import com.android.model.Usuario;

public class UsuarioDAO implements ValidaAcceso {

	private static final Logger LOGGER = Logger.getLogger(UsuarioDAO.class);
	private SqlSessionFactory sqlSessionFactory = null;

	public UsuarioDAO() {
		sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> selectAll() {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			List<Usuario> list = session.selectList("Usuario.getAll");
			return list;
		} finally {
			session.close();
		}
	}

	public Usuario selectById(int id) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			Usuario contact = (Usuario) session
					.selectOne("Usuario.getById", id);
			return contact;
		} finally {
			session.close();
		}
	}

	public void update(Usuario contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.update("Usuario.update", contact);
			session.commit();
		} finally {
			session.close();
		}
	}

	public void insert(Usuario contact) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.insert("Usuario.insert", contact);
			session.commit();
		} finally {
			session.close();
		}
	}

	public void delete(int id) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.delete("Usuario.deleteById", id);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public boolean validaAcceso(Usuario usuario) throws ValidaAccesoException {

		LOGGER.info("VALIDA ACCESO USUARIO");
		SqlSession session = sqlSessionFactory.openSession();
		try {

			UsuarioDAO dao = new UsuarioDAO();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("nombre", usuario.getNombre());
			map.put("password", usuario.getPassword());

			session.selectOne("Usuario.spValidaUsuario", map);
			return (Boolean) map.get("resultado");

		} catch (Exception e) {
			throw new ValidaAccesoException(e);
		} finally {
			session.close();
		}

	}
}
