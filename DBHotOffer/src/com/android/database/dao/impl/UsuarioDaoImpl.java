package com.android.database.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import cl.hotoffer.business.validador.ValidaObject;
import cl.hotoffer.exception.UsuarioException;

import com.android.database.dao.UsuarioDAO;
import com.android.database.mysql.ConnectionFactory;
import com.android.model.Persona;
import com.android.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDAO {

	private static final Logger LOGGER = Logger.getLogger(UsuarioDaoImpl.class);
	private SqlSessionFactory sqlSessionFactory = null;

	public UsuarioDaoImpl() {
		sqlSessionFactory = ConnectionFactory.getInstance()
				.getSqlSessionFactory();
	}

	public List<Usuario> selectAll() throws UsuarioException {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			@SuppressWarnings("unchecked")
			List<Usuario> list = session.selectList("Usuario.getAll");
			return list;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new UsuarioException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Usuario selectById(int id) throws UsuarioException {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			Usuario contact = (Usuario) session
					.selectOne("Usuario.getById", id);
			return contact;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new UsuarioException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Persona persona) throws UsuarioException {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.update("Usuario.update", persona);
			session.commit();
		} catch (Exception e) {
			LOGGER.error(e);
			throw new UsuarioException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void insert(Persona persona) throws UsuarioException {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.insert("Usuario.sp_creaPersona", persona);
			session.commit();
		} catch (Exception e) {
			LOGGER.error(e);
			throw new UsuarioException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(int id) throws UsuarioException {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.delete("Usuario.deleteById", id);
			session.commit();
		} catch (Exception e) {
			LOGGER.error(e);
			throw new UsuarioException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean validaAcceso(Usuario usuario) throws UsuarioException {

		LOGGER.info("VALIDA ACCESO USUARIO");
		SqlSession session = sqlSessionFactory.openSession();
		try {
			new ValidaObject().validate(usuario);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("nombre", usuario.getNombre());
			map.put("password", usuario.getPassword());
			LOGGER.info("[CALL Usuario.spValidaUsuario]");
			session.selectOne("Usuario.spValidaUsuario", map);
			session.commit();
			return (Boolean) map.get("resultado");

		} catch (Exception e) {
			LOGGER.error(e);
			throw new UsuarioException(e);
		} finally {
			session.close();
		}

	}
}
