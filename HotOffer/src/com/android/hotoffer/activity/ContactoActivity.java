package com.android.hotoffer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.android.hotoffer.to.Usuario;
import com.example.hotoffer.R;

public class ContactoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_contacto);

		TestSQLite lite = new TestSQLite(this);

		if (lite.insertUser(new Usuario("Cesar", "Araya"))) {

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_contacto, menu);
		return true;
	}

}
