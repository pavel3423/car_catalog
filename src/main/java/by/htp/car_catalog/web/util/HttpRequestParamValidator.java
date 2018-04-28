package by.htp.car_catalog.web.util;

import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullParamException;

public final class HttpRequestParamValidator {
	private HttpRequestParamValidator() {
	}

	public static void validateObjectNotNull(Object... objects) {
		for (Object o : objects) {

			if (o == null) {

				throw new ValidateNullParamException("Empty parameter recieved");
			}

		}
	}

	public static void validateStringNotNull(String... str) {
		for (String s : str) {

			if ("".equals(s)) {

				throw new ValidateNullParamException("Empty parameter recieved");
			}

		}
	}
}
