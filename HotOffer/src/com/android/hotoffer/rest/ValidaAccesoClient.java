package com.android.hotoffer.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.android.hotoffer.to.Usuario;

public class ValidaAccesoClient {

	public boolean valida(Usuario usuario) {

		String url = "http://192.168.1.8:8080/WSRestHotOffer/valida/acceso?nombre="
				+ usuario.getNombre() + "&password=" + usuario.getPassword();
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Usuario> requestEntity = new HttpEntity<Usuario>(
				requestHeaders);

		ResponseEntity<Boolean> response = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, Boolean.class);

		return response.getBody();

	}
}
