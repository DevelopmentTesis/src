package com.android.hotoffer.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

	private static Utils instance = null;

	private Utils() {
		// TODO Auto-generated constructor stub
	}

	public static Utils getInstance() {
		synchronized (Utils.class) {
			if (instance == null) {
				instance = new Utils();
			}
		}
		return instance;
	}

	public String fecha(String fecha) {
		Date inicio = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.getDefault());
		Date result;
		try {
			result = df.parse(fecha);

			long milisegundos = inicio.getTime() - result.getTime();

			long seg = milisegundos / 1000;

			long horas = seg / 3600;

			seg -= horas * 3600;

			long min = seg / 60;

			return formatFecha(horas, min);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String formatFecha(long horas, long min) {

		StringBuffer fecha = new StringBuffer();

		fecha.append(horas).append("hrs").append(min).append("min");

		return fecha.toString();
	}

}
