package com.android.hotoffer.to;

public final class Publicacion {

	private int idPublicacion;
	private int idTipoPublicacion;
	private int idEstado;
	private String descrTipo;
	private Usuario usuario;
	private String comentario;
	private String precio;
	private String tienda;
	private Geolocalizacion geolocalizacion;
	private String fechaPublicacion;

	public Publicacion() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public int getIdTipoPublicacion() {
		return idTipoPublicacion;
	}

	public void setIdTipoPublicacion(int idTipoPublicacion) {
		this.idTipoPublicacion = idTipoPublicacion;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescrTipo() {
		return descrTipo;
	}

	public void setDescrTipo(String descrTipo) {
		this.descrTipo = descrTipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public Geolocalizacion getGeolocalizacion() {
		return geolocalizacion;
	}

	public void setGeolocalizacion(Geolocalizacion geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

}
