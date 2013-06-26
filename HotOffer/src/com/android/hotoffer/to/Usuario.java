package com.android.hotoffer.to;

public class Usuario {

	private String nombre;
	private String password;

	public Usuario(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}

	public Usuario() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
