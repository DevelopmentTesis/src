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
import org.json.JSONObject;

import com.android.hotoffer.to.Geolocalizacion;
import com.android.hotoffer.to.Publicacion;
import com.android.hotoffer.to.Usuario;

public class PublicacionClient {

	public List<Publicacion> obtenerPublicaciones() {
		HttpClient httpClient = new DefaultHttpClient();
		String url = "http://192.168.1.4:8080/WSRestHotOffer/service/publicacion/obtener/";
		HttpGet get = new HttpGet(url);

		get.setHeader("content-type", "application/json");
		List<Publicacion> publi = new ArrayList<Publicacion>();
		try {
			HttpResponse resp = httpClient.execute(get);

			String reString = EntityUtils
					.toString(resp.getEntity(), HTTP.UTF_8);

			JSONArray array = new JSONArray(reString);

			Publicacion publicacion = null;
			for (int i = 0; i < array.length(); i++) {

				publicacion = new Publicacion();
				JSONObject json = array.getJSONObject(i);
				publicacion.setIdTipoPublicacion(json
						.getInt("idTipoPublicacion"));
				publicacion.setComentario(json.getString("comentario"));
				publicacion.setDescrTipo(json.getString("descrTipo"));
				publicacion.setTienda(json.getString("tienda"));
				publicacion.setPrecio(json.getString("precio"));
				publicacion.setFechaPublicacion(json
						.getString("fechaPublicacion"));

				JSONObject usuario = json.getJSONObject("usuario");
				publicacion.setUsuario(new Usuario(usuario.getString("nombre"),
						null));

				JSONObject geo = json.getJSONObject("geolocalizacion");
				publicacion.setGeolocalizacion(new Geolocalizacion(geo
						.getInt("cordLatitud"), geo.getInt("cordLonguitud")));

				publi.add(publicacion);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return publi;
	}
}
