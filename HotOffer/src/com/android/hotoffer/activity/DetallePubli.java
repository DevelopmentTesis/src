package com.android.hotoffer.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.android.hotoffer.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetallePubli extends FragmentActivity {

	private GoogleMap mMap;
	private Double longitud;
	private Double latitud;

	@Override
	public void onCreate(Bundle state) {
		super.onCreate(state);
		setContentView(R.layout.map);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		Bundle bundle = getIntent().getExtras();

		this.latitud = Double.valueOf(bundle.getString("lat"));
		this.longitud = Double.valueOf(bundle.getString("long"));
		setUpMapIfNeeded();

	}

	private void setUpMapIfNeeded() {
		final LatLng posicion = new LatLng(this.latitud, this.longitud);
		if (mMap == null) {
			mMap = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.mapsGo)).getMap();
			mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posicion, 15));
			// mMap.setMyLocationEnabled(true); captura mi ubicacion
			mMap.getUiSettings().setZoomControlsEnabled(false);
			mMap.getUiSettings().setCompassEnabled(true);
			mMap.addMarker(new MarkerOptions().position(posicion).icon(
					BitmapDescriptorFactory.fromResource(R.drawable.fuego)));

		}
	}
}
