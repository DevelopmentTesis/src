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
import com.android.hotoffer.to.Publicacion;
import com.android.hotoffer.util.SQLUtils;

public class Publicaciones extends SQLiteOpenHelper {

	private final static String CREATE_TB_TIPO_PUBLICACION = "CREATE TABLE TIPO_PUBLICACION ( idPublicacion  text, descripcion text)";
	private final static String DROP_TB_USUARIO = "DROP TABLE IF EXISTS TIPO_PUBLICACION";

	public Publicaciones(Context context) {
		super(context, Constants.NAME_DB, null, Constants.VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TB_TIPO_PUBLICACION);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DROP_TB_USUARIO);
		onCreate(db);
	}

	public boolean insertTipoPublicaciones(List<Publicacion> publ) {

		SQLiteDatabase db = this.getWritableDatabase();
		try {
			onUpgrade(db, Constants.VERSION, Constants.VERSION);
			ContentValues values = new ContentValues();

			if (SQLUtils.isExistTable(db, Constants.TB_TIPO_PUBLICACION)) {
				for (Publicacion publicacion : publ) {
					values.put("idPublicacion",
							publicacion.getIdTipoPublicacion());
					values.put("descripcion", publicacion.getDescrTipo());
					db.insert(Constants.TB_TIPO_PUBLICACION, null, values);
				}

			}
			return true;
		} catch (Exception e) {
			Log.w("Exception :", e);
			return false;
		} finally {
			db.close();
		}

	}

	public List<Publicacion> getLista() {

		SQLiteDatabase db = this.getReadableDatabase();
		List<Publicacion> list = new ArrayList<Publicacion>();
		Publicacion publicacion = null;

		try {

			if (SQLUtils.isExistTable(db, Constants.TB_TIPO_PUBLICACION)) {
				Cursor cursor = db.query(Constants.TB_TIPO_PUBLICACION, null,
						null, null, null, null, null, null);

				if (cursor.moveToFirst()) {
					do {
						publicacion = new Publicacion();
						publicacion.setIdTipoPublicacion(cursor.getInt(0));
						publicacion.setDescrTipo(cursor.getString(1));
						list.add(publicacion);
					} while (cursor.moveToNext());
				}

			}

		} catch (Exception e) {
			Log.w("Exception :", e);
		} finally {
			db.close();
		}

		return list;
	}

	public String[] toArray() {

		List<Publicacion> publ = getLista();
		int lenght = publ.size();
		String[] array = new String[lenght];

		for (int i = 0; i < lenght; i++) {
			array[i] = publ.get(i).getDescrTipo();
		}
		return array;
	}

}
