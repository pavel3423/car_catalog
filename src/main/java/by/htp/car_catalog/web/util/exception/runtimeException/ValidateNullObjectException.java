package by.htp.car_catalog.web.util.exception.runtimeException;

public class ValidateNullObjectException extends ValidateNullParamException {

	private static final long serialVersionUID = 2108784613761539122L;

	public ValidateNullObjectException() {
	}

	public ValidateNullObjectException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValidateNullObjectException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateNullObjectException(String message) {
		super(message);
	}

	public ValidateNullObjectException(Throwable cause) {
		super(cause);
	}

}
