package com.android.hotoffer.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.android.hotoffer.constants.Constants;
import com.android.hotoffer.to.Recordar;
import com.android.hotoffer.util.SQLUtils;

public class RecordarAccesoSQLite extends SQLiteOpenHelper {

	private static final String CREATE_TB_ACCESO = "CREATE TABLE RECORDAR (user  TEXT, pass TEXT)";
	private final static String DROP_TB_ACCESO = "DROP TABLE IF EXISTS RECORDAR";

	public RecordarAccesoSQLite(Context context) {
		super(context, Constants.NAME_DB, null, Constants.VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("onCreate", "Creando tabla " + Constants.TB_RECORDAR);
		db.execSQL(CREATE_TB_ACCESO);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i("onUpgrade", "Actualizando Base de Datos " + Constants.NAME_DB);
		db.execSQL(DROP_TB_ACCESO);
		onCreate(db);
	}

	public boolean saveData(String user, String pass) {
		SQLiteDatabase db = this.getWritableDatabase();
		try {

			ContentValues values = new ContentValues();
			values.put("user", user);
			values.put("pass", pass);

			if (SQLUtils.isExistTable(db, Constants.TB_RECORDAR)) {
				db.insert(Constants.TB_RECORDAR, null, values);
			} else {
				onCreate(db);
				db.insert(Constants.TB_RECORDAR, null, values);
			}

			return true;
		} catch (Exception e) {
			Log.w("Exception :", e);
		} finally {
			db.close();
		}
		return false;
	}

	public Recordar selRecordar() {

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(Constants.TB_RECORDAR, null, null, null, null,
				null, null);
		Recordar recordar = null;

		try {

			if (cursor.moveToFirst()) {
				recordar = new Recordar();
				while (cursor.moveToNext()) {
					Log.i("User", cursor.getString(0));
					Log.i("Pass", cursor.getString(1));

					recordar.setUser(cursor.getString(0));
					recordar.setPass(cursor.getString(1));

				}
			}
		} catch (Exception e) {
			Log.w("Exception :", e);
		} finally {
			db.close();
		}

		return recordar;
	}
}
