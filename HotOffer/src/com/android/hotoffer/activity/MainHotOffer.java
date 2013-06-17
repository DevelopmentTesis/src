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

	// @Override
	// public void run() {
	//
	// try {
	// int waited = 0;
	// while (waited < 5000) {
	// Thread.sleep(100);
	// waited += 100;
	// }
	// } catch (InterruptedException e) {
	// // do nothing
	// } finally {
	// finish();
	//
	// }
	// }

}
