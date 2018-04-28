package by.htp.car_catalog.web.util.exception.runtimeException;

public class ValidateNullParamException extends RuntimeException {

	private static final long serialVersionUID = -6927051771242956629L;

	public ValidateNullParamException() {
		super();
	}

	public ValidateNullParamException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ValidateNullParamException(String message, Throwable cause) {

		super(message, cause);

	}

	public ValidateNullParamException(String message) {

		super(message);

	}

	public ValidateNullParamException(Throwable cause) {

		super(cause);

	}

}