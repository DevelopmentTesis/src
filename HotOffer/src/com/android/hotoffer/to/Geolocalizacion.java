package com.android.hotoffer.to;

public class Geolocalizacion {

	private String cordLatitud;
	private String cordLonguitud;

	public Geolocalizacion() {
		// TODO Auto-generated constructor stub
	}

	public Geolocalizacion(String cordLatitud, String cordLonguitud) {
		super();
		this.cordLatitud = cordLatitud;
		this.cordLonguitud = cordLonguitud;
	}

	public String getCordLatitud() {
		return cordLatitud;
	}

	public void setCordLatitud(String cordLatitud) {
		this.cordLatitud = cordLatitud;
	}

	public String getCordLonguitud() {
		return cordLonguitud;
	}

	public void setCordLonguitud(String cordLonguitud) {
		this.cordLonguitud = cordLonguitud;
	}

}
