package by.htp.car_catalog.web.util.exception.runtimeException;

public class ValidateNullStringException extends ValidateNullParamException {

	private static final long serialVersionUID = 3753073296936215301L;

	public ValidateNullStringException() {
	}

	public ValidateNullStringException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValidateNullStringException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateNullStringException(String message) {
		super(message);
	}

	public ValidateNullStringException(Throwable cause) {
		super(cause);
	}

}
