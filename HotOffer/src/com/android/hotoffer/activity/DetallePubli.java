package com.android.hotoffer.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.hotoffer.R;
import com.android.hotoffer.rest.PublicacionClient;
import com.android.hotoffer.to.Geolocalizacion;
import com.android.hotoffer.to.Publicacion;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetallePubli extends FragmentActivity {

	private GoogleMap mMap;
	private Publicacion publicacion;
	private PublicacionClient client = new PublicacionClient();
	static final int DETALLE_DIALOG = 666;

	@Override
	public void onCreate(Bundle state) {
		super.onCreate(state);
		setContentView(R.layout.map);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		ListView listView = (ListView) findViewById(R.id.comentarios_usuario);

		List<Publicacion> comentarios = new ArrayList<Publicacion>();

		Bundle bundle = getIntent().getExtras();
		publicacion = setDatosPublicidad(bundle);

		TextView comentario = (TextView) findViewById(R.id.comentario);
		comentario.setText(publicacion.getComentario());
		comentarios = client.comentariosPublicacion(publicacion
				.getIdPublicacion());

		listView.setAdapter(new ListHandler(this, R.layout.comentarios,
				comentarios) {

			@Override
			public void onEntrada(Object entrada, View view) {
				TextView comentario = (TextView) view
						.findViewById(R.id.comentarios);
				if (comentario != null)
					comentario.setText(((Publicacion) entrada).getComentario());

				TextView usuario = (TextView) view
						.findViewById(R.id.usuarioCom);
				if (usuario != null)
					usuario.setText(((Publicacion) entrada).getUsuario()
							.getNombre());

			}
		});

		TextView detalle = (TextView) findViewById(R.id.detalle);

		detalle.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(DETALLE_DIALOG);
			}
		});

		setUpMapIfNeeded();

	}

	private void setUpMapIfNeeded() {

		double lat = Double.valueOf(publicacion.getGeolocalizacion()
				.getCordLatitud());
		double lon = Double.valueOf(publicacion.getGeolocalizacion()
				.getCordLonguitud());

		final LatLng posicion = new LatLng(lat, lon);
		if (mMap == null) {
			mMap = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.mapsGo)).getMap();
			mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posicion, 15));
			mMap.setMyLocationEnabled(true);
			mMap.getUiSettings().setMyLocationButtonEnabled(false);
			mMap.getUiSettings().setZoomControlsEnabled(false);
			mMap.getUiSettings().setCompassEnabled(true);
			mMap.addMarker(new MarkerOptions().position(posicion)
					.title(publicacion.getTienda()).visible(true));

		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {

		DialogFragment dialogFragment = new DialogFragment();
		Dialog dialog = null;

		switch (id) {
		case DETALLE_DIALOG:

			AlertDialog.Builder builder = new AlertDialog.Builder(this);

			builder.setMessage(
					"Tienda : " + publicacion.getTienda() + "\nTipo Oferta : "
							+ publicacion.getDescrTipo() + "\nPrecio : "
							+ publicacion.getPrecio()).setPositiveButton(
					"Aceptar", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
			dialog = builder.create();
			break;

		default:
			break;
		}

		return dialog;
	}

	private Publicacion setDatosPublicidad(Bundle bundle) {
		Publicacion publi = new Publicacion();

		publi.setIdPublicacion(bundle.getInt("idPub"));
		publi.setComentario(bundle.getString("comentario"));
		publi.setGeolocalizacion(new Geolocalizacion(bundle.getString("lat"),
				bundle.getString("long")));
		publi.setTienda(bundle.getString("tienda"));
		publi.setPrecio(bundle.getString("precio"));
		publi.setDescrTipo(bundle.getString("tipoPub"));

		return publi;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.detalle_comentar, menu);
		return true;
	}

}
