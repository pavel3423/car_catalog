package by.htp.car_catalog.web.util;

public final class HttpRequestParamValidator {
	private HttpRequestParamValidator() {
	}

	public static void validateRequestParamNotNull(String... str) {
		for (String s : str) {
			if (s == null) {
				throw new ValidateNullParamException("Empty parameter recieved");
			}
		}
	}
}
