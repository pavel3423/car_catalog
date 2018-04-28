package by.htp.car_catalog.web.util.exception.runtimeException;

public class RequestIOException extends RuntimeException {

	private static final long serialVersionUID = -3021610806905468425L;

	public RequestIOException() {
	}

	public RequestIOException(String message) {
		super(message);
	}

	public RequestIOException(Throwable cause) {
		super(cause);
	}

	public RequestIOException(String message, Throwable cause) {
		super(message, cause);
	}

	public RequestIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
