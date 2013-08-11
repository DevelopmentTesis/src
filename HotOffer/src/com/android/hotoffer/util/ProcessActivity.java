package com.android.hotoffer.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class ProcessActivity extends AsyncTask<Object, Void, String> {
	private Context context = null;
	private ProgressDialog process;

	public ProcessActivity() {
	}

	public ProcessActivity(Context context) {
		this.context = context;
	}

	@Override
	protected String doInBackground(Object... params) {
		return null;
	}

	@Override
	public void onPreExecute() {
		super.onPreExecute();
		process = new ProgressDialog(context);
		process.setMessage("Cargando...");
		process.show();
	}

	@Override
	public void onPostExecute(String result) {
		super.onPostExecute(result);
		process.dismiss();
	}

}
