package com.android.hotoffer.activity;

import com.android.hotoffer.R;
import com.android.hotoffer.rest.PublicacionClient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ComentarioPublicacion extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.comentario);
		Button comentar = (Button) findViewById(R.id.ComentarPub);
		final Bundle bundle = getIntent().getExtras();
		final PublicacionClient client = new PublicacionClient();

		comentar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				client.comentar("1", "desdeapp", "1");
			}
		});

	}

}
