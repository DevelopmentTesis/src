package cl.hotoffer.exception;

public class UsuarioException extends Exception {

	private static final long serialVersionUID = -2063219985224332531L;

	public UsuarioException() {
		super();
	}

	public UsuarioException(String message) {
		super(message);
	}

	public UsuarioException(Throwable e) {
		super(e);
	}

	public UsuarioException(String message, Throwable e) {
		super(message, e);
	}

}
