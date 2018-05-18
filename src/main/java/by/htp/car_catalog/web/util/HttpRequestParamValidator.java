package by.htp.car_catalog.web.util;

import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullObjectException;
import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullStringException;

public final class HttpRequestParamValidator {
    private HttpRequestParamValidator() {
    }

    public static void validateObjectNotNull(Object... objects) throws ValidateNullObjectException {
	for (Object o : objects) {

	    if (o == null) {

		throw new ValidateNullObjectException();
	    }

	}
    }

    public static void validateStringNotNull(String... str) throws ValidateNullStringException {
	for (String s : str) {

	    if ("".equals(s) || s == null) {

		throw new ValidateNullStringException();
	    }

	}
    }
}
