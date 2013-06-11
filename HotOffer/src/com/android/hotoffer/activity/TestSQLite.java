package com.android.hotoffer.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.hotoffer.to.Usuario;

public class TestSQLite extends SQLiteOpenHelper {

	private final static String NAME_DB = "TEST_BD";
	private final static Integer VERSION = 1;
	private final static String CREATE_TB_USUARIO = "CREATE TABLE USUARIO ( nombre  text, apellido text)";
	private final static String DROP_TB_USUARIO = "DROP TABLE IF EXISTS USUARIO";

	private final static String TB_USUARIO = "USUARIO";

	public TestSQLite(Context context) {
		super(context, NAME_DB, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TB_USUARIO);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DROP_TB_USUARIO);
		onCreate(db);
	}

	public boolean insertUser(Usuario us) {

		SQLiteDatabase db = this.getWritableDatabase();
		try {

			ContentValues values = new ContentValues();
			values.put("nombre", us.getNombre());
			values.put("apellido", us.getApellido());
			db.insert(TB_USUARIO, null, values);

			return true;
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		} finally {
			db.close();
		}

		return false;
	}

	public Usuario getLista() {

		SQLiteDatabase db = this.getReadableDatabase();
		Usuario usuario = new Usuario();

		Cursor cursor = db.query(TB_USUARIO, null, null, null, null, null,
				null, null);

		try {

			if (cursor.moveToFirst()) {

				usuario.setNombre(cursor.getString(0));
			}

		} catch (Exception e) {

		} finally {
			db.close();
		}

		return usuario;
	}

}
