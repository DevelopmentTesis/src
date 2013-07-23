package com.android.hotoffer.activity;

import com.android.hotoffer.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetallePublicActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalle_lista);
		Bundle bundle = getIntent().getExtras();
		TextView view = (TextView) findViewById(R.id.detalle_tienda);

		view.setText(bundle.getString("tienda"));

	}

}
