package com.android.hotoffer.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.android.hotoffer.sqlite.RecordarAccesoSQLite;
import com.example.hotoffer.R;

public class AccesoActivity extends Activity implements OnClickListener {

	private RecordarAccesoSQLite lite = null;

	public AccesoActivity() {
		lite = new RecordarAccesoSQLite(this);
	}

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.init_session_hotoffer);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Button button = (Button) findViewById(R.id.btnInitSession);
		button.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		EditText user = (EditText) findViewById(R.id.user);
		EditText pass = (EditText) findViewById(R.id.pass);
		CheckBox checkBox = (CheckBox) findViewById(R.id.checkRecordar);

		try {

			if (checkBox.isChecked()) {
				if (save(user, pass)) {
					Log.i("SAVE", "GUARDADO");
				}
			}

			Class<?> clazz = Class
					.forName("com.android.hotoffer.activity.ContactoActivity");

			iniciar(clazz);
			// TODO VALIDAR ACCESO USUARIO

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void iniciar(Class<?> c) {
		Intent i = new Intent(this, c);
		startActivity(i);
	}

	public boolean save(EditText user, EditText pass) {
		boolean status = false;
		if (user != null && pass != null) {
			status = lite.saveData(user.getText().toString(), pass.getText()
					.toString());
		}
		return status;
	}
}
