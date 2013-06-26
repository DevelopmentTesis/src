package com.android.hotoffer.activity;

import android.os.Bundle;

import com.example.hotoffer.R;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class EjemploMaps extends MapActivity {

	private MapView mapa = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);

		// Obtenemos una referencia al control MapView
		mapa = (MapView) findViewById(R.id.mapa);

		// Mostramos los controles de zoom sobre el mapa
		mapa.setBuiltInZoomControls(true);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
