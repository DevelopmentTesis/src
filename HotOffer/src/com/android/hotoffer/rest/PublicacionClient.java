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
import org.xml.sax.XMLReader;

import com.android.hotoffer.to.Publicacion;
import com.google.android.gms.internal.p;

public class PublicacionClient {

	public List<Publicacion> obtenerPublicaciones() {
		HttpClient httpClient = new DefaultHttpClient();
		String url = "http://192.168.1.4:8080/WSRestHotOffer/service/publicacion/obtener/";
		HttpGet get = new HttpGet(url);

		get.setHeader("content-type", "application/xml");
		List<Publicacion> publi = new ArrayList<Publicacion>();
		try {
			HttpResponse resp = httpClient.execute(get);

			String reString = EntityUtils
					.toString(resp.getEntity(), HTTP.UTF_8);

			JSONArray array = new JSONArray(reString);
			String string;
			Publicacion publicacion = null;
			for (int i = 0; i < array.length(); i++) {
				publicacion = new Publicacion();
				JSONObject jsonObject = array.getJSONObject(i);
				publicacion.setComentario(jsonObject.getString("comentario"));
				publicacion.setDescrTipo(jsonObject.getString("descrTipo"));

				publi.add(publicacion);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return publi;
	}
}
