package com.android.hotoffer.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.hotoffer.R;

public class MainActivity extends Activity {

	private ListView lista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listado);

		ArrayList<String> datos = new ArrayList<String>();

		datos.add(String.valueOf("Valor"));

		lista = (ListView) findViewById(R.id.ListView_listado);
		lista.setAdapter(new ListHandler(this, R.layout.entrada, datos) {
			@Override
			public void onEntrada(Object entrada, View view) {
				if (entrada != null) {
					TextView texto_superior_entrada = (TextView) view
							.findViewById(R.id.textView_superior);
					if (texto_superior_entrada != null)
						texto_superior_entrada.setText((String) entrada);

					// TextView texto_inferior_entrada = (TextView) view
					// .findViewById(R.id.textView_inferior);
					// if (texto_inferior_entrada != null)
					// texto_inferior_entrada
					// .setText(((Lista_entrada) entrada)
					// .get_textoDebajo());
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
				String elegido = (String) pariente.getItemAtPosition(posicion);

				CharSequence texto = "Seleccionado: " + elegido;
				Toast toast = Toast.makeText(MainActivity.this, texto,
						Toast.LENGTH_LONG);
				toast.show();
			}
		});

	}

}
