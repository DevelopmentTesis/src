package com.android.hotoffer.activity;

import com.android.hotoffer.R;
import com.android.hotoffer.rest.PublicacionClient;
import com.android.hotoffer.util.ProcessActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComentarioPublicacion extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.comentario);
		Button comentar = (Button) findViewById(R.id.ComentarPub);

		comentar.setOnClickListener(new View.OnClickListener() {
			Bundle bundle = getIntent().getExtras();
			PublicacionClient client = new PublicacionClient();
			Integer idPub = bundle.getInt("idPub");
			EditText comentario = (EditText) findViewById(R.id.setComentario);

			@Override
			public void onClick(View v) {
				boolean response = client.comentar(idPub, comentario.getText()
						.toString(), MainHotOffer.isUser);
				final Intent intent = new Intent();
				final ProcessActivity process = new ProcessActivity(
						ComentarioPublicacion.this);
				process.onPreExecute();
				if (response) {

					new Thread(new Runnable() {
						public void run() {

							intent.setClass(ComentarioPublicacion.this,
									ListaPublicacion.class);
							startActivity(intent);
							process.onPostExecute("Fin Proceso");
						}
					}).start();
				}
			}

		});

	}

}
