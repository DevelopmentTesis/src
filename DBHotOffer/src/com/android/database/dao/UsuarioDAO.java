package com.android.database.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.android.database.mysql.MyBatisConnectionFactory;
import com.android.model.Usuario;

public class UsuarioDAO {

	private SqlSessionFactory sqlSessionFactory = null;

	public UsuarioDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
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

	public boolean isUsuario(Map<String, Object> map) {

		SqlSession session = sqlSessionFactory.openSession();

		try {

			session.selectOne("Usuario.spValidaUsuario", map);
			
			return (Boolean) map.get("resultado");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;

	}
}
