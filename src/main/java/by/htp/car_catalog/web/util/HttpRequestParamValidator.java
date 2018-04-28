package by.htp.car_catalog.web.util;

public final class HttpRequestParamValidator {
	private HttpRequestParamValidator() {
	}

	public static void validateRequestParamNotNull(Object... objects) {
		for (Object o : objects) {

			if (o == null) {

				throw new ValidateNullParamException("Empty parameter recieved");
			}

		}
	}
}
