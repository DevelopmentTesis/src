package com.android.hotoffer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.android.hotoffer.R;
import com.android.hotoffer.rest.PublicacionClient;
import com.android.hotoffer.to.Publicacion;

public class ListaPublicacionActivity extends Activity {

	private ListView lista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listado);

		PublicacionClient client = new PublicacionClient();

		lista = (ListView) findViewById(R.id.ListView_listado);
		lista.setAdapter(new ListHandler(this, R.layout.entrada, client
				.obtenerPublicaciones()) {
			@Override
			public void onEntrada(Object entrada, View view) {
				if (entrada != null) {
					TextView texto_superior_entrada = (TextView) view
							.findViewById(R.id.usuario);
					if (texto_superior_entrada != null)
						texto_superior_entrada.setText(((Publicacion) entrada)
								.getUsuario().getNombre());

					TextView texto_inferior_entrada = (TextView) view
							.findViewById(R.id.fecha);
					if (texto_inferior_entrada != null)
						texto_inferior_entrada.setText(((Publicacion) entrada)
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

		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> pariente, View view,
					int posicion, long id) {
				Publicacion elegido = (Publicacion) pariente
						.getItemAtPosition(posicion);

				// CharSequence texto = "Seleccionado: " +
				// elegido.getComentario();

				Intent intent = new Intent();
				intent.setClass(ListaPublicacionActivity.this,
						DetallePublicActivity.class);
				intent.putExtra("tienda", elegido.getTienda());
				startActivity(intent);

				// Toast toast = Toast.makeText(MainActivity.this,
				// texto,Toast.LENGTH_LONG);
				// toast.show();
			}
		});

	}

}
