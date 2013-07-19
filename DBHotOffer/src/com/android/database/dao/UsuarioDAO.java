package com.android.database.dao;

import java.util.List;

import cl.hotoffer.exception.UsuarioException;

import com.android.model.Persona;
import com.android.model.Usuario;

/**
 * 
 * @author César Araya Acosta
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
	boolean validaAcceso(Usuario usuario) throws UsuarioException;

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
	Usuario selectById(int id) throws UsuarioException;

	/**
	 * Metodo que permite actualizar regitro de usuario
	 * 
	 * @param usuario
	 * @throws UsuarioException
	 */
	void update(Persona persona) throws UsuarioException;

	/**
	 * Metodo que permite crear registro de Persona
	 * 
	 * @param usuario
	 * @throws UsuarioException
	 */
	void insert(Persona persona) throws UsuarioException;

	/**
	 * Metodo que permite eliminar Persona
	 * 
	 * @param usuario
	 * @throws UsuarioException
	 */
	public void delete(int id) throws UsuarioException;

}
