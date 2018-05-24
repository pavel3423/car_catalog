package by.htp.car_catalog.web.util.exception.runtimeException;

public class RepeatorException extends RuntimeException {

    private static final long serialVersionUID = 8379949874021998229L;

    public RepeatorException() {
	super();
    }

    public RepeatorException(String message, Throwable cause) {

	super(message, cause);

    }

    public RepeatorException(String message) {

	super(message);

    }

    public RepeatorException(Throwable cause) {

	super(cause);

    }

}