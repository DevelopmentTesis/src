package com.android.hotoffer.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLUtils {

	public static boolean isExistTable(SQLiteDatabase db, String table) {

		if (table == null || db == null || !db.isOpen()) {
			return false;
		}

		Cursor cursor = db
				.rawQuery(
						"SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?",
						new String[] { "table", table });
		if (!cursor.moveToFirst()) {
			return false;
		}
		int count = cursor.getInt(0);
		cursor.close();
		return count > 0;

	}

}
