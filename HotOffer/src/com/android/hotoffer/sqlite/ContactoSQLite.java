package com.android.hotoffer.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.android.hotoffer.constants.Constants;
import com.android.hotoffer.to.Usuario;

public class ContactoSQLite extends SQLiteOpenHelper {

	private final static String CREATE_TB_USUARIO = "CREATE TABLE USUARIO ( nombre  text, apellido text)";
	private final static String DROP_TB_USUARIO = "DROP TABLE IF EXISTS USUARIO";

	public ContactoSQLite(Context context) {
		super(context, Constants.NAME_DB, null, Constants.VERSION);
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
			db.insert(Constants.TB_USUARIO, null, values);

			return true;
		} catch (Exception e) {
			Log.w("Exception :", e);
		} finally {
			db.close();
		}

		return false;
	}

	public List<String> getLista() {

		SQLiteDatabase db = this.getReadableDatabase();
		List<String> list = new ArrayList<String>();
		Cursor cursor = db.query(Constants.TB_USUARIO, null, null, null, null,
				null, null, null);

		try {

			if (cursor.moveToFirst()) {

				while (cursor.moveToNext()) {
					list.add(cursor.getString(0));

				}
			}
		} catch (Exception e) {
			Log.w("Exception :", e);
		} finally {
			db.close();
		}

		return list;
	}

}
