package com.android.hotoffer.rest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

import com.android.hotoffer.to.Usuario;

public class Client {

	public Client() {

	}

	public String getDataService() {

		String url = "http://192.168.1.8:8080/WSRestHotOffer/valida/acceso/";
		HttpHeaders requestHeaders = new HttpHeaders();

		JSONObject dato = new JSONObject();

		try {
			dato.put("", "");
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();

			HttpEntity<Usuario> requestEntity = new HttpEntity<Usuario>(
					requestHeaders);

			ResponseEntity<String> response = restTemplate.exchange(url,
					HttpMethod.GET, requestEntity, String.class);

			return response.getBody();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

}
