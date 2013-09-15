/**
 * 
 */
package com.android.hotoffer.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.hotoffer.R;
import com.android.hotoffer.rest.PublicacionClient;
import com.android.hotoffer.sqlite.Publicaciones;
import com.android.hotoffer.to.Geolocalizacion;
import com.android.hotoffer.to.Publicacion;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * @author caraya
 * 
 */
public class Publicar extends FragmentActivity implements LocationListener {

	private static final int ID_DIALOG = 2;
	private GoogleMap mMap;
	private double lat;
	private double lon;
	private int idTipo;
	private String provider;
	private EditText tienda;
	private TextView tipoPub;
	private EditText precio;
	private EditText comentario;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.publicar);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		provider = locationManager.getBestProvider(criteria, false);
		Location location = locationManager.getLastKnownLocation(provider);
		onLocationChanged(location);
		setUpMapIfNeeded();

		tienda = (EditText) findViewById(R.id.tienda);
		precio = (EditText) findViewById(R.id.precio);

		tipoPub = (TextView) findViewById(R.id.tipoPublicacion);
		comentario = (EditText) findViewById(R.id.pub_comentario);
		tipoPub.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(ID_DIALOG);

			}
		});

		Button button = (Button) findViewById(R.id.publicar);

		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				PublicacionClient client = new PublicacionClient();

				Publicacion publicacion = new Publicacion();

				publicacion.setTienda(tienda.getText().toString());
				publicacion.setIdTipoPublicacion(idTipo);

				publicacion.setGeolocalizacion(new Geolocalizacion(String
						.valueOf(lat), String.valueOf(lon)));

				publicacion.setPrecio(precio.getText().toString());
				publicacion.setComentario(comentario.getText().toString());
				client.publicar(publicacion);
				Intent intent = new Intent();
				intent.setClass(Publicar.this, ListaPublicacion.class);
				startActivity(intent);
			}
		});

	}

	private void setUpMapIfNeeded() {

		final LatLng posicion = new LatLng(lat, lon);
		if (mMap == null) {
			mMap = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.mapsGo)).getMap();
			mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

			mMap.setMyLocationEnabled(true);
			mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posicion, 15));
			mMap.getUiSettings().setMyLocationButtonEnabled(true);
			mMap.getUiSettings().setZoomControlsEnabled(false);
			mMap.getUiSettings().setCompassEnabled(true);

		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		Dialog dialog = new Dialog(this);
		final Publicaciones p = new Publicaciones(this);

		switch (id) {
		case ID_DIALOG:

			builder.setTitle("Buscar Publicaciones por :");
			builder.setSingleChoiceItems(p.toArray(), -1,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int item) {
							int id = item;
							tipoPub.setText(p.toArray()[id]);
							idTipo += item;
							dialog.dismiss();
						}
					});
			dialog = builder.create();
			break;

		}
		return dialog;
	}

	@Override
	public void onLocationChanged(Location location) {

		this.lat = location.getLatitude();
		this.lon = location.getLongitude();

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}
}
