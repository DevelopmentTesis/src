package com.android.hotoffer.activity;

import com.android.hotoffer.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



public class MainHotOffer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_hotoffer);
		// Intent intent = new Intent(MainHotOffer.this, AccesoActivity.class);
		Intent intent = new Intent(MainHotOffer.this, MainActivity.class);
		startActivity(intent);
	}
}
