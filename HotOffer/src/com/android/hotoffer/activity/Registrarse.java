package com.android.hotoffer.activity;

import java.util.Calendar;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.android.hotoffer.R;
import com.android.hotoffer.rest.ValidaAccesoClient;

@SuppressLint("CutPasteId")
public class Registrarse extends Activity {

	private TextView tvFecha;

	private TextView tvDisplayDate;
	private DatePicker dpResult;
	private int anio;
	private int mes;
	private int dia;

	static final int DATE_DIALOG_ID = 999;
	static final int SX_DIALOG_ID = 111;
	static final int PAIS_DIALOG_ID = 222;
	static final int CIUDAD_DIALOG_ID = 333;

	private ValidaAccesoClient client = new ValidaAccesoClient();

	@SuppressLint("CutPasteId")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configurar_cuenta);
		setCurrentDateOnView();
		tvFecha = (TextView) findViewById(R.id.fecha);
		tvFecha.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);

			}
		});

		TextView sexo = (TextView) findViewById(R.id.sexo);
		sexo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(SX_DIALOG_ID);

			}
		});

		TextView pais = (TextView) findViewById(R.id.nom_pais);
		pais.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				showDialog(PAIS_DIALOG_ID);

			}
		});

		TextView ciudad = (TextView) findViewById(R.id.nom_ciudad);
		ciudad.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(CIUDAD_DIALOG_ID);

			}
		});

		Button registrarse = (Button) findViewById(R.id.enviar);

		registrarse.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText nombre = (EditText) findViewById(R.id.nombre);
				EditText apellido = (EditText) findViewById(R.id.apell);
				TextView fechaN = (TextView) findViewById(R.id.fecha);
				TextView sex = (TextView) findViewById(R.id.sexo);
				TextView paissel = (TextView) findViewById(R.id.nom_pais);
				TextView ciuda = (TextView) findViewById(R.id.nom_ciudad);
				EditText user = (EditText) findViewById(R.id.usuario);
				EditText pass = (EditText) findViewById(R.id.contras);
				client.crearAcceso(nombre.getText().toString(), apellido
						.getText().toString(), fechaN.getText().toString(), sex
						.getText().toString(), Integer.valueOf(paissel
						.getText().toString()), Integer.valueOf(ciuda.getText()
						.toString()), user.getText().toString(), pass.getText()
						.toString());
			}
		});

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		Dialog dialog = null;
		switch (id) {
		case DATE_DIALOG_ID:

			return new DatePickerDialog(this, mDateSetListener, anio, mes, dia);

		case SX_DIALOG_ID:

			builder.setTitle("Sexo");
			final String sexo[] = { "Mujer", "Hombre", "Otro" };
			final TextView sexTextView = (TextView) findViewById(R.id.sexo);

			builder.setSingleChoiceItems(sexo, -1,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int item) {

							for (int i = 0; i < sexo.length; i++) {
								if (i == item) {
									sexTextView.setText(sexo[item]);
								}
							}

							dialog.dismiss();
						}
					});

			dialog = builder.create();

			break;

		case PAIS_DIALOG_ID:

			builder.setTitle("Pais");
			final String pais[] = { "Chile" };
			final TextView paisTextView = (TextView) findViewById(R.id.nom_pais);

			builder.setSingleChoiceItems(pais, -1,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int item) {

							for (int i = 0; i < pais.length; i++) {
								if (i == item) {
									paisTextView.setText(pais[item]);

								}

							}

							dialog.dismiss();
						}
					});

			dialog = builder.create();

			break;

		case CIUDAD_DIALOG_ID:

			builder.setTitle("Ciudad");
			final String ciudad[] = { "Santiago", "Valparaiso", "Viña del Mar" };
			final TextView ciudadTextView = (TextView) findViewById(R.id.nom_ciudad);

			builder.setSingleChoiceItems(ciudad, -1,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int item) {

							for (int i = 0; i < ciudad.length; i++) {
								if (i == item) {
									ciudadTextView.setText(ciudad[item]);
								}
							}

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

			StringBuffer buffer = new StringBuffer();

			tvDisplayDate.setText(new StringBuilder()
					// Month is 0 based, just add 1
					.append(mes + 1).append("-").append(dia).append("-")
					.append(anio).append(" "));

		}

	};

	public void setCurrentDateOnView() {

		tvDisplayDate = (TextView) findViewById(R.id.fecha);
		dpResult = (DatePicker) findViewById(R.id.dpResult);

		final Calendar c = Calendar.getInstance();
		anio = c.get(Calendar.YEAR);
		mes = c.get(Calendar.MONTH);
		dia = c.get(Calendar.DAY_OF_MONTH);

		tvDisplayDate.setText(new StringBuilder().append(mes + 1).append("-")
				.append(dia).append("-").append(anio).append(" "));

		dpResult.init(anio, mes, dia, null);

	}

}
