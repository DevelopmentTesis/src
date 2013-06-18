package com.android.hotoffer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.hotoffer.R;

public class MainHotOffer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_hotoffer);
		Intent intent = new Intent(this, AccesoActivity.class);

		startActivity(intent);
	}
}
