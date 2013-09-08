package com.android.hotoffer.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.android.hotoffer.constants.Constants;
import com.android.hotoffer.util.SQLUtils;

public class RecordarAcceso extends SQLiteOpenHelper {

	private static final String CREATE_TB_ACCESO = "CREATE TABLE RECORDAR (idAcceso INTEGER)";
	private final static String DROP_TB_ACCESO = "DROP TABLE IF EXISTS RECORDAR";

	public RecordarAcceso(Context context) {
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

	public boolean saveData(Integer idAcceso) {
		SQLiteDatabase db = this.getWritableDatabase();
		try {

			ContentValues values = new ContentValues();
			values.put("idAcceso", idAcceso);

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

	public Integer selRecordar() {

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(Constants.TB_RECORDAR, null, null, null, null,
				null, null);

		try {

			if (cursor.moveToFirst()) {
				while (cursor.moveToNext()) {
					return cursor.getInt(0);
				}
			}
		} catch (Exception e) {
			Log.w("Exception :", e);
		} finally {
			db.close();
		}
		return null;

	}
}
