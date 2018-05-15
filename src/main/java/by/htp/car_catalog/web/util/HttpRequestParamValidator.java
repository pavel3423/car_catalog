package by.htp.car_catalog.web.util;

import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullObjectException;
import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullStringException;

public final class HttpRequestParamValidator {
    private HttpRequestParamValidator() {
    }

    public static void validateObjectNotNull(Object... objects) {
	for (Object o : objects) {

	    if (o == null) {

		throw new ValidateNullObjectException();
	    }

	}
    }

    public static void validateStringNotNull(String... str) {
	for (String s : str) {

	    if ("".equals(s)) {

		throw new ValidateNullStringException();
	    }

	}
    }
}
