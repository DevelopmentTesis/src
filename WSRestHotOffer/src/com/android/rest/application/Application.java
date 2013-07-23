package com.android.rest.application;

import java.util.HashSet;
import java.util.Set;

import com.android.rest.acceso.RestServiceImpl;

/**
 * Servlet que permite invocar implementacion de servicios Rest
 * 
 * @author kerne
 * 
 */
public class Application extends javax.ws.rs.core.Application {

	private Set<Class<?>> classes = new HashSet<Class<?>>();
	private Set<Object> singletons = new HashSet<Object>();

	public Application() {
		this.classes.add(RestServiceImpl.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
