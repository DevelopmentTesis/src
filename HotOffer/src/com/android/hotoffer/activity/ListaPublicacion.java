package com.android.hotoffer.activity;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.android.hotoffer.R;
import com.android.hotoffer.rest.PublicacionClient;
import com.android.hotoffer.to.Publicacion;

public class ListaPublicacion extends Activity {

	private static final int ID_DIALOG = 1;
	private PublicacionClient client = new PublicacionClient();
	private ListView lista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listado);

		lista = (ListView) findViewById(R.id.ListView_listado);

		cargarLista(client.obtenerPublicaciones());

		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> pariente, View view,
					int posicion, long id) {
				Publicacion elegido = (Publicacion) pariente
						.getItemAtPosition(posicion);

				Intent intent = new Intent();
				intent.setClass(ListaPublicacion.this, DetallePublicidad.class);
				intent.putExtra("tienda", elegido.getTienda());
				startActivity(intent);

			}
		});
	}

	public void cargarLista(List<Publicacion> p) {
		lista.setAdapter(new ListHandler(this, R.layout.entrada, p) {
			@Override
			public void onEntrada(Object entrada, View view) {
				if (entrada != null) {
					TextView usuario = (TextView) view
							.findViewById(R.id.usuario);
					if (usuario != null)
						usuario.setText(((Publicacion) entrada).getUsuario()
								.getNombre());

					TextView fecha = (TextView) view.findViewById(R.id.fecha);
					if (fecha != null)
						fecha.setText(((Publicacion) entrada)
								.getFechaPublicacion());

					TextView comentario = (TextView) view
							.findViewById(R.id.comentario);
					if (comentario != null)
						comentario.setText(((Publicacion) entrada)
								.getComentario());
					//
					// ImageView imagen_entrada = (ImageView) view
					// .findViewById(R.id.imageView_imagen);
					// if (imagen_entrada != null)
					// imagen_entrada
					// .setImageResource(((Lista_entrada) entrada)
					// .get_idImagen());
				}
			}
		});
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		Dialog dialog = new Dialog(this);

		switch (id) {
		case ID_DIALOG:

			final String[] items = { "Computación", "Vestuario", "Comida",
					"Literatura" };
			builder.setTitle("Buscar Publicaciones por :");
			builder.setSingleChoiceItems(items, -1,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int item) {
							int pos = item + 1;
							cargarLista(client.buscarPublicaciones(String
									.valueOf(pos)));
							dialog.dismiss();
						}
					});
			dialog = builder.create();
			break;

		}
		return dialog;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		getMenuInflater().inflate(R.menu.menu_hotoffer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.Buscar:
			showDialog(ID_DIALOG);
			break;
		case R.id.Publicar:

			break;

		default:
			return super.onOptionsItemSelected(item);
		}
		return false;
	}

}
