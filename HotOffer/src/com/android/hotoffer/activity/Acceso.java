package com.android.hotoffer.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.hotoffer.R;
import com.android.hotoffer.rest.ValidaAccesoClient;
import com.android.hotoffer.sqlite.RecordarAcceso;
import com.android.hotoffer.to.Usuario;
import com.android.hotoffer.util.ProcessActivity;

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
				final EditText user = (EditText) findViewById(R.id.nom);
				final EditText pass = (EditText) findViewById(R.id.pass);
				final Intent i = new Intent();
				Toast toast;
				final ProcessActivity process = new ProcessActivity(Acceso.this);
				process.onPreExecute();

				try {

					new Thread(new Runnable() {
						public void run() {
							ValidaAccesoClient client = new ValidaAccesoClient();
							boolean isOK = client.valida(new Usuario(user
									.getText().toString(), pass.getText()
									.toString()));
							if (isOK) {
								i.setClass(Acceso.this, ListaPublicacion.class);
								startActivity(i);
								process.onPostExecute("Fin Proceso");
							} else {
								process.onPostExecute("Fin Proceso");
							}
						}
					}).start();

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
		RecordarAcceso lite = new RecordarAcceso(Acceso.this);
		boolean status = false;
		if (user != null && pass != null) {
			status = lite.saveData(user.getText().toString(), pass.getText()
					.toString());
		}
		return status;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.mAbout:
			showDialog(1);
			break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected Dialog onCreateDialog(int id) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		View view = LayoutInflater.from(this).inflate(R.layout.about, null);
		builder.setView(view);
		builder.setCancelable(true);

		switch (id) {
		case 1:
			builder.setTitle("About HotOffer");

			break;

		default:
			break;
		}

		return builder.create();
	}

}
