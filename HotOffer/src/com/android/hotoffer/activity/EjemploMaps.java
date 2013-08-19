package com.android.hotoffer.activity;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;

import com.android.hotoffer.R;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class EjemploMaps extends MapActivity {
	private MapView mapView;
	private MapController mapController;
	private LocationManager locationManager;
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);

		mapView = (MapView) findViewById(R.id.zoom);
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(true);
		mapView.setStreetView(false);
		mapView.setTraffic(false);
		mapController = mapView.getController();
		mapController.setZoom(14);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 0, new GeoUpdateHandler());
//		LinearLayout zoomLayout = (LinearLayout) findViewById(R.id.zoom);
//		View zoomView = mapView.getZoomControls();
//
//		zoomLayout.addView(zoomView, new LinearLayout.LayoutParams(
//				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//		mapView.displayZoomControls(true);

	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
