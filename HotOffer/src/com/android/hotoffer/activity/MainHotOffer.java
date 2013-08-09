package com.android.hotoffer.activity;

import com.android.hotoffer.R;
import com.android.hotoffer.sqlite.RecordarAcceso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainHotOffer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_hotoffer);
		Intent intent = null;
		RecordarAcceso acceso = new RecordarAcceso(this);

		if (acceso.selRecordar()) {
			intent = new Intent(this, ListaPublicacion.class);
		} else {
			intent = new Intent(this, Acceso.class);
		}
		startActivity(intent);
	}
}
