package com.android.hotoffer.rest;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.android.hotoffer.to.Usuario;

public class ValidaAccesoClient {

	public Boolean valida(Usuario usuario) {

		String url = "http://192.168.1.5:8080/WSRestHotOffer/service/valida/acceso?nombre="
				+ usuario.getNombre() + "&password=" + usuario.getPassword();

		String result = null;
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		try {
			ResponseHandler<String> handler = new BasicResponseHandler();

			result = httpclient.execute(request, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Boolean.valueOf(result);

	}

	public void crearAcceso(String nombre, String apellido, String fechaN,
			String sexo, Integer pais, Integer ciudad, String user, String pass) {

		String url = "http://192.168.1.5:8080/WSRestHotOffer/service/crear/acceso?nom="
				+ nombre
				+ "&ape="
				+ apellido
				+ "&fNac="
				+ fechaN
				+ "&sx="
				+ sexo
				+ "&idPais="
				+ pais
				+ "&idCiudad="
				+ ciudad
				+ "&user="
				+ user + "&pass=" + pass;

		String result = null;
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		try {
			ResponseHandler<String> handler = new BasicResponseHandler();

			result = httpclient.execute(request, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	
}
