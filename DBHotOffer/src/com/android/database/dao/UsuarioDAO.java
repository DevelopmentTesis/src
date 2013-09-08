package com.android.database.dao;

import java.util.List;

import cl.hotoffer.exception.UsuarioException;

import com.android.model.Persona;
import com.android.model.Usuario;

/**
 * Interface UsuarioDAO, expone metodo que interactuan con la base de datos
 * 
 * @author César Patricio Araya Acosta
 * 
 */
public interface UsuarioDAO {

	/**
	 * Metodo que permite Valida Acceso de Usuario
	 * 
	 * @param usuario
	 * @return
	 * @throws UsuarioException
	 */
	Integer validaAcceso(Usuario usuario) throws UsuarioException;

	/**
	 * Metodo que permite seleccionar todos los usuario registrados
	 * 
	 * @return List<Usuario>
	 * @throws UsuarioException
	 */
	List<Usuario> selectAll() throws UsuarioException;

	/**
	 * Metodo que permite seleccionar usuario por id
	 * 
	 * @param id
	 * @return Usuario
	 * @throws UsuarioException
	 */
	List<Usuario> selectByName(String name) throws UsuarioException;

	/**
	 * Metodo que permite actualizar regitro de usuario
	 * 
	 * @param usuario
	 * @throws UsuarioException
	 */
	void update(Persona persona) throws UsuarioException;

	/**
	 * * Metodo que permite crear registro de Persona
	 * 
	 * @param persona
	 * @return Integer id
	 * @throws UsuarioException
	 */
	Integer insert(Persona persona) throws UsuarioException;

	/**
	 * Metodo que permite eliminar Persona
	 * 
	 * @param usuario
	 * @throws UsuarioException
	 */
	public void delete(int id) throws UsuarioException;

}
