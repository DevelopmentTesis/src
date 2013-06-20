package com.android.hotoffer.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

import com.android.hotoffer.to.Usuario;

public class Client {

	private String nombre;

	public Client(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
	}

	public String getDataService() {

		String url = "http://190.22.211.85:8080/testWSRest/rest/helloworld/saluda/";
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		Usuario usuario = new Usuario();
		usuario.setNombre("cesar");
		HttpEntity<Usuario> requestEntity = new HttpEntity<Usuario>(
				requestHeaders);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, String.class);
		return response.getBody();
	}

}
