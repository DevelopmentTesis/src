package com.android.hotoffer.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.hotoffer.R;
import com.android.hotoffer.rest.ValidaAccesoClient;
import com.android.hotoffer.sqlite.RecordarAccesoSQLite;
import com.android.hotoffer.to.Usuario;

public class Acceso extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.inicio);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		Button init = (Button) findViewById(R.id.iniciar);
		TextView registro = (TextView) findViewById(R.id.registrarse);

		init.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText user = (EditText) findViewById(R.id.nom);
				EditText pass = (EditText) findViewById(R.id.pass);
				Intent i = new Intent();
				Toast toast;

				if (save(user, pass)) {
					Log.i("SAVE", "GUARDADO");
				}

				try {
					ValidaAccesoClient client = new ValidaAccesoClient();
					boolean isOK = client.valida(new Usuario(user.getText()
							.toString(), pass.getText().toString()));
					if (isOK) {
						i.setClass(Acceso.this, ListaPublicacion.class);
						startActivity(i);
					} else {
						toast = Toast.makeText(Acceso.this,
								"Error de Validacion", Toast.LENGTH_LONG);
						toast.show();
					}

				} catch (Exception e) {
					Log.w("Exception", e);
					toast = Toast.makeText(Acceso.this,
							"Error :" + e.getCause(), Toast.LENGTH_LONG);
					toast.show();
				}

			}
		});

		registro.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(Acceso.this, Registrarse.class);
				startActivity(i);

			}
		});

	}

	public boolean save(EditText user, EditText pass) {
		RecordarAccesoSQLite lite = new RecordarAccesoSQLite(Acceso.this);
		boolean status = false;
		if (user != null && pass != null) {
			status = lite.saveData(user.getText().toString(), pass.getText()
					.toString());
		}
		return status;
	}
}
