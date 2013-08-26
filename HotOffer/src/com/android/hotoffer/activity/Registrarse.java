package com.android.hotoffer.activity;

import java.util.Calendar;

import com.android.hotoffer.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.CallLog.Calls;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Registrarse extends Activity {

	private EditText editText;
	private int anio;
	private int mes;
	private int dia;

	static final int DATE_DIALOG_ID = 999;
	static final int SX_DIALOG_ID = 111;
	static final int PAIS_DIALOG_ID = 222;
	static final int CIUDAD_DIALOG_ID = 333;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configurar_cuenta);

		editText = (EditText) findViewById(R.id.fecha);
		editText.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				showDialog(DATE_DIALOG_ID);
			}
		});
		
		
		EditText sexo = (EditText) findViewById(R.id.sexo);
		sexo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				showDialog(SX_DIALOG_ID);

			}
		});

	
	
	EditText pais = (EditText) findViewById(R.id.nom_pais);
	pais.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			showDialog(PAIS_DIALOG_ID);

		}
	});
	
	EditText ciudad = (EditText) findViewById(R.id.nom_ciudad);
	ciudad.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			showDialog(CIUDAD_DIALOG_ID);

		}
	});

}

	@Override
	protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		Dialog dialog = null;
		switch (id) {
		case DATE_DIALOG_ID:

			LinearLayout layout = (LinearLayout) findViewById(R.id.calendarioLayout);
			View child = layout.inflate(this, R.layout.calendario, null);

			builder.setTitle("Fecha Nacimiento");
			builder.setView(child);

			dialog = builder.create();
			break;

		case SX_DIALOG_ID:

			builder.setTitle("Sexo");
			String sexo[] = { "Mujer", "Hombre", "Otro" };

			builder.setSingleChoiceItems(sexo, -1,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int item) {
							int pos = item + 1;

							dialog.dismiss();
						}
					});

			dialog = builder.create();

			break;

		case PAIS_DIALOG_ID:

			builder.setTitle("Pais");
			String pais[] = { "Chile"};

			builder.setSingleChoiceItems(pais, -1,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int item) {
							int pos = item + 1;

							dialog.dismiss();
						}
					});

			dialog = builder.create();

			break;
			
		case CIUDAD_DIALOG_ID:

			builder.setTitle("Ciudad");
			String ciudad[] = { "Santiago","Valparaiso","Viña del Mar"};

			builder.setSingleChoiceItems(ciudad, -1,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int item) {
							int pos = item + 1;

							dialog.dismiss();
						}
					});

			dialog = builder.create();

			break;

		}
		return dialog;
	}

	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int fec_anio, int fec_mes,
				int fec_dia) {

			anio = fec_anio;
			mes = fec_mes;
			dia = fec_dia;
		}

	};

}
