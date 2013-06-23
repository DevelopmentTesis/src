package com.android.database.exception;

public class ValidaAccesoException extends Exception {

	private static final long serialVersionUID = -2063219985224332531L;

	public ValidaAccesoException() {
		super();
	}

	public ValidaAccesoException(String message) {
		super(message);
	}

	public ValidaAccesoException(Throwable e) {
		super(e);
	}

	public ValidaAccesoException(String message, Throwable e) {
		super(message, e);
	}

}
