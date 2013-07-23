package com.android.hotoffer.to;

public class Geolocalizacion {

	private int cordLatitud;
	private int cordLonguitud;

	public Geolocalizacion(int cordLatitud, int cordLonguitud) {
		super();
		this.cordLatitud = cordLatitud;
		this.cordLonguitud = cordLonguitud;
	}

	public Geolocalizacion() {
		// TODO Auto-generated constructor stub
	}

	public int getCordLatitud() {
		return cordLatitud;
	}

	public void setCordLatitud(int cordLatitud) {
		this.cordLatitud = cordLatitud;
	}

	public int getCordLonguitud() {
		return cordLonguitud;
	}

	public void setCordLonguitud(int cordLonguitud) {
		this.cordLonguitud = cordLonguitud;
	}
}
