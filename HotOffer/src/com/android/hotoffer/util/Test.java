package com.android.hotoffer.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	public static void main(String[] args) {

		HttpClient httpClient = new DefaultHttpClient();

		HttpPost post = new HttpPost(
				"http://192.168.1.8:8080/testWSRest/rest/helloworld/saluda/cesar");

		post.setHeader("content-type", "application/json");

		JSONObject dato = new JSONObject();

		try {
			dato.put("Nombre", "TEXT");
			dato.put("Telefono", 1);

			StringEntity entity = new StringEntity(dato.toString());
			post.setEntity(entity);

			HttpResponse resp = httpClient.execute(post);
			String respStr = EntityUtils.toString(resp.getEntity());

			if (respStr.equals("true")) {
				System.out.println("ok");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
