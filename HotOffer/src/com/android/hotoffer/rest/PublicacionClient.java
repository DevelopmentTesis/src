package com.android.hotoffer.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.hotoffer.to.Geolocalizacion;
import com.android.hotoffer.to.Publicacion;
import com.android.hotoffer.to.Usuario;

public class PublicacionClient {

	private List<Publicacion> publi = new ArrayList<Publicacion>();

	public List<Publicacion> obtenerPublicaciones() {

		HttpClient httpClient = new DefaultHttpClient();
		String url = "http://192.168.1.5:8080/WSRestHotOffer/service/publicacion/obtener/";
		HttpGet get = new HttpGet(url);

		get.setHeader("content-type", "application/json");

		try {
			HttpResponse resp = httpClient.execute(get);
			String reString = EntityUtils
					.toString(resp.getEntity(), HTTP.UTF_8);
			JSONArray array = new JSONArray(reString);

			return lista(array);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return publi;
	}

	public List<Publicacion> buscarPublicaciones(String tipo) {
		HttpClient httpClient = new DefaultHttpClient();
		String url = "http://192.168.1.5:8080/WSRestHotOffer/service/publicacion/buscar?id="
				+ tipo;
		HttpGet get = new HttpGet(url);
		get.setHeader("content-type", "application/json");
		HttpResponse resp;
		try {
			resp = httpClient.execute(get);
			String reString = EntityUtils
					.toString(resp.getEntity(), HTTP.UTF_8);

			JSONArray array = new JSONArray(reString);

			return lista(array);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return publi;

	}

	public List<Publicacion> lista(JSONArray array) throws JSONException {

		Publicacion publicacion = null;
		publi.clear();

		for (int i = 0; i < array.length(); i++) {

			publicacion = new Publicacion();
			
			JSONObject json = array.getJSONObject(i);
			publicacion.setIdTipoPublicacion(json.getInt("idTipoPublicacion"));
			publicacion.setComentario(json.getString("comentario"));
			publicacion.setDescrTipo(json.getString("descrTipo"));
			publicacion.setTienda(json.getString("tienda"));
			publicacion.setPrecio(json.getString("precio"));
			publicacion.setFechaPublicacion(json.getString("fechaPublicacion"));

			JSONObject usuario = json.getJSONObject("usuario");
			publicacion.setUsuario(new Usuario(usuario.getString("nombre"),
					null));

			JSONObject geo = json.getJSONObject("geolocalizacion");
			publicacion.setGeolocalizacion(new Geolocalizacion(geo
					.getInt("cordLatitud"), geo.getInt("cordLonguitud")));

			publi.add(publicacion);
		}
		return publi;
	}
}
