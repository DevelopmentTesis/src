package com.android.hotoffer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.hotoffer.R;

public class AccesoActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.init_session_hotoffer);
		Button button = (Button) findViewById(R.id.btnInitSession);

		button.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		EditText text = (EditText) findViewById(R.id.user);

		Class<?> clazz;
		try {
			clazz = Class
					.forName("com.android.hotoffer.activity.ContactoActivity");

			if (text.getText().toString().equals("cesar")) {
				iniciar(clazz);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void iniciar(Class<?> c) {
		Intent i = new Intent(this, c);
		startActivity(i);
	}
}
