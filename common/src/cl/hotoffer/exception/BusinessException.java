package cl.hotoffer.exception;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1111068398194339585L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable e) {
		super(e);
	}

	public BusinessException(String message, Throwable e) {
		super(message, e);
	}

}
