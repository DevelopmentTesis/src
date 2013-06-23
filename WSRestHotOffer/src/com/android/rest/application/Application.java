package com.android.rest.application;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.android.rest.acceso.RestValidaAccesoImple;

public class Application extends javax.ws.rs.core.Application {

	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public Application() {
		classes.add(RestValidaAccesoImple.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return Collections.EMPTY_SET;
	}

}
