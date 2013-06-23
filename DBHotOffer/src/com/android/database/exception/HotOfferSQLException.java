package com.android.database.exception;

import java.sql.SQLException;

public class HotOfferSQLException extends SQLException {

	private static final long serialVersionUID = 8201534417918172422L;

	public HotOfferSQLException() {
		super();
	}

	public HotOfferSQLException(String message) {
		super(message);
	}

	public HotOfferSQLException(Throwable e) {
		super(e);
	}

	public HotOfferSQLException(String message, Throwable e) {
		super(message, e);
	}

}
