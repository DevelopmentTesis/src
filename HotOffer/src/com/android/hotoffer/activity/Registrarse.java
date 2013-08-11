package com.android.hotoffer.activity;

import com.android.hotoffer.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Registrarse extends Activity {

	private TextView btnChangeDate;

	static final int DATE_DIALOG_ID = 999;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configurar_cuenta);

		addListenerOnButton();

	}

	public void addListenerOnButton() {

		btnChangeDate = (TextView) findViewById(R.id.btnChangeDate);

		btnChangeDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				showDialog(DATE_DIALOG_ID);

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

			builder.setPositiveButton("Confirmar",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialogo1, int id) {

						}
					});

			dialog = builder.create();
			break;

		}
		return dialog;
	}

}
