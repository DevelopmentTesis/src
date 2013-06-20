package com.android.hotoffer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.hotoffer.sqlite.ContactoSQLite;
import com.android.hotoffer.to.Usuario;
import com.example.hotoffer.R;

public class ContactoActivity extends Activity {

	private ListView listView;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_contacto);

		ContactoSQLite lite = new ContactoSQLite(ContactoActivity.this);

		listView = (ListView) findViewById(R.id.mainListView);

		lite.insertUser(new Usuario("Cesar", "Araya"));
		TextView t = (TextView) findViewById(R.id.testConecto);
		Bundle bundle = getIntent().getExtras();

		t.setText(String.valueOf(bundle.getString("mensaje")));

		adapter = new ArrayAdapter<String>(this, R.layout.simplerow,
				lite.getLista());

		listView.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_contacto, menu);
		return true;
	}

}
