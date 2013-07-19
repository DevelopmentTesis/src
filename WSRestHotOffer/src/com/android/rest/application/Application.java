package com.android.rest.application;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.android.rest.acceso.RestServiceImpl;

public class Application extends javax.ws.rs.core.Application {

	private static final Logger LOGGER = Logger.getLogger(Application.class);
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	private Set<Object> singletons = new HashSet<Object>();

	public Application() {
		LOGGER.info("init application");
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
