package by.htp.car_catalog.web.util;

public final class HttpRequestParamValidator {
	private HttpRequestParamValidator() {
	}

	public static boolean validateRequestParamNotNull(String... str) {
		for (String s : str) {

			if (s == null) {

				return false;
			}

		}

		return true;
	}
}
