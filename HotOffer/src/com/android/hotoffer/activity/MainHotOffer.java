package com.android.hotoffer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.android.hotoffer.R;
import com.android.hotoffer.rest.PublicacionClient;
import com.android.hotoffer.sqlite.Publicaciones;
import com.android.hotoffer.sqlite.RecordarAcceso;
import com.android.hotoffer.util.ProcessActivity;

public class MainHotOffer extends Activity {

	private PublicacionClient client = new PublicacionClient();
	public static Integer isUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_hotoffer);

		final ProcessActivity process = new ProcessActivity(this);
		process.onPreExecute();

		new Thread(new Runnable() {
			public void run() {

				RecordarAcceso acceso = new RecordarAcceso(MainHotOffer.this);
				Intent intent;
				isUser = acceso.selRecordar();
				Publicaciones pub = new Publicaciones(MainHotOffer.this);
				pub.insertTipoPublicaciones(client.getTipoPublicaciones());
				if (isUser != null) {
					intent = new Intent(MainHotOffer.this,
							ListaPublicacion.class);
					startActivity(intent);
					process.onPostExecute("Fin Proceso");

				} else {
					intent = new Intent(MainHotOffer.this, Acceso.class);
					startActivity(intent);
					process.onPostExecute("Fin Proceso");
				}
			}
		}).start();

	}
}
