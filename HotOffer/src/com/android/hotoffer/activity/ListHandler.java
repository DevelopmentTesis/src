package com.android.hotoffer.activity;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class ListHandler extends BaseAdapter {

	private List<?> entradas;
	private int R_layout_IdView;
	private Context contexto;

	public ListHandler(Context contexto, int R_layout_IdView,
			List<?> list) {
		super();
		this.contexto = contexto;
		this.entradas = list;
		this.R_layout_IdView = R_layout_IdView;
	}

	@Override
	public View getView(int posicion, View view, ViewGroup pariente) {
		if (view == null) {
			LayoutInflater vi = (LayoutInflater) contexto
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = vi.inflate(R_layout_IdView, null);
		}
		onEntrada(entradas.get(posicion), view);
		return view;
	}

	@Override
	public int getCount() {
		return entradas.size();
	}

	@Override
	public Object getItem(int posicion) {
		return entradas.get(posicion);
	}

	@Override
	public long getItemId(int posicion) {
		return posicion;
	}

	/**
	 * Devuelve cada una de las entradas con cada una de las vistas a la que
	 * debe de ser asociada
	 * 
	 * @param entrada
	 *            La entrada que será la asociada a la view. La entrada es del
	 *            tipo del paquete/handler
	 * @param view
	 *            View particular que contendrá los datos del paquete/handler
	 */
	public abstract void onEntrada(Object entrada, View view);

}
