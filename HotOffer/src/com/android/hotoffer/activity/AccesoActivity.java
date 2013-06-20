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

import com.android.hotoffer.rest.Client;
import com.android.hotoffer.sqlite.RecordarAccesoSQLite;
import com.example.hotoffer.R;

public class AccesoActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.init_session_hotoffer);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		Button button = (Button) findViewById(R.id.btnInitSession);
		button.setOnClickListener(AccesoActivity.this);

	}

	@Override
	public void onClick(View v) {
		EditText user = (EditText) findViewById(R.id.user);
		EditText pass = (EditText) findViewById(R.id.pass);
		CheckBox checkBox = (CheckBox) findViewById(R.id.checkRecordar);

		if (checkBox.isChecked()) {
			if (save(user, pass)) {
				Log.i("SAVE", "GUARDADO");
			}
		}
		try {

			Intent i = new Intent();
			i.setClass(AccesoActivity.this, ContactoActivity.class);
			Client response = new Client("Cesar");
			i.putExtra("mensaje", response.getDataService());
			startActivity(i);

		} catch (Exception e) {
			Log.w("Exception", e);
		}
		// TODO VALIDAR ACCESO USUARIO

	}

	public boolean save(EditText user, EditText pass) {
		RecordarAccesoSQLite lite = new RecordarAccesoSQLite(
				AccesoActivity.this);
		boolean status = false;
		if (user != null && pass != null) {
			status = lite.saveData(user.getText().toString(), pass.getText()
					.toString());
		}
		return status;
	}
}
