package com.android.hotoffer.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.hotoffer.constants.Constants;
import com.android.hotoffer.to.Geolocalizacion;
import com.android.hotoffer.to.Publicacion;
import com.android.hotoffer.to.Usuario;

public class PublicacionClient {

	private List<Publicacion> publi = null;

	public List<Publicacion> obtenerPublicaciones() {

		HttpClient httpClient = new DefaultHttpClient();
		String url = "http://" + Constants.IP_SERVER
				+ ":8080/WSRestHotOffer/service/publicacion/obtener/";
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
		String url = "http://" + Constants.IP_SERVER
				+ ":8080/WSRestHotOffer/service/publicacion/buscar?id=" + tipo;
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
		publi = new ArrayList<Publicacion>();
		// publi.clear();

		for (int i = 0; i < array.length(); i++) {

			publicacion = new Publicacion();

			JSONObject json = array.getJSONObject(i);
			publicacion.setIdPublicacion(json.getInt("idPublicacion"));
			publicacion.setIdTipoPublicacion(json.getInt("idTipoPublicacion"));
			publicacion.setComentario(json.getString("comentario"));
			publicacion.setDescrTipo(json.getString("descrTipo"));
			publicacion.setIdEstado(json.getInt("idEstado"));
			publicacion.setTienda(json.getString("tienda"));
			publicacion.setPrecio(json.getString("precio"));
			publicacion.setFechaPublicacion(json.getString("fechaPublicacion"));

			JSONObject usuario = json.getJSONObject("usuario");
			publicacion.setUsuario(new Usuario(usuario.getString("nombre"),
					null));

			JSONObject geo = json.getJSONObject("geolocalizacion");
			publicacion.setGeolocalizacion(new Geolocalizacion(geo
					.getString("cordLatitud"), geo.getString("cordLonguitud")));

			publi.add(publicacion);
		}
		return publi;
	}

	public List<Publicacion> getTipoPublicaciones() {

		String url = "http://" + Constants.IP_SERVER
				+ ":8080/WSRestHotOffer/service/publicacion/tipo";
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		List<Publicacion> list = new ArrayList<Publicacion>();
		get.setHeader("content-type", "application/json");

		try {
			HttpResponse resp = httpClient.execute(get);
			String reString = EntityUtils
					.toString(resp.getEntity(), HTTP.UTF_8);
			JSONArray array = new JSONArray(reString);
			Publicacion pub = new Publicacion();
			for (int i = 0; i < array.length(); i++) {
				pub = new Publicacion();
				JSONObject json = array.getJSONObject(i);
				pub.setIdTipoPublicacion(json.getInt("idPublicacion"));
				pub.setDescrTipo(json.getString("descripcion"));
				list.add(pub);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Publicacion> comentariosPublicacion(int id) {

		HttpClient httpClient = new DefaultHttpClient();
		String url = "http://" + Constants.IP_SERVER
				+ ":8080/WSRestHotOffer/service/publicacion/comentarios?id="
				+ id;

		List<Publicacion> comentarios = new ArrayList<Publicacion>();
		Publicacion publicacion;

		HttpGet get = new HttpGet(url);

		get.setHeader("content-type", "application/json");
		HttpResponse resp;
		try {
			resp = httpClient.execute(get);
			String reString = EntityUtils
					.toString(resp.getEntity(), HTTP.UTF_8);

			JSONArray array = new JSONArray(reString);

			for (int i = 0; i < array.length(); i++) {
				publicacion = new Publicacion();
				JSONObject json = array.getJSONObject(i);
				publicacion.setComentario(json.getString("comentario"));
				publicacion.setUsuario(new Usuario(json.getString("usuario"),
						(String) null));

				comentarios.add(publicacion);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comentarios;
	}

	public Boolean comentar(Integer idPub, String comentario, Integer idUser) {

		String url = "http://" + Constants.IP_SERVER
				+ ":8080/WSRestHotOffer/service/publicacion/comentar?idPub="
				+ idPub + "&comentario=" + comentario.replace(" ", "%20")
				+ "&idUser=" + idUser;

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

}
