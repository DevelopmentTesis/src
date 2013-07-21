package cl.hotoffer.exception;

public class PublicacionException extends Exception {

	private static final long serialVersionUID = -3817073858036812838L;

	public PublicacionException() {
		super();
	}

	public PublicacionException(String e) {
		super(e);
	}

	public PublicacionException(Throwable e) {
		super(e);
	}

	public PublicacionException(String msn, Throwable e) {
		super(msn, e);
	}

}
