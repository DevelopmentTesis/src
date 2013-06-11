package com.android.hotoffer.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hotoffer.R;

public class ContactoActivity extends Activity {

	private ListView listView;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_contacto);

		//TestSQLite lite = new TestSQLite(this);

		listView = (ListView) findViewById(R.id.mainListView);

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			list.add("Cesar");
		}

		adapter = new ArrayAdapter<String>(this, R.layout.simplerow, list);

		listView.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_contacto, menu);
		return true;
	}

}
