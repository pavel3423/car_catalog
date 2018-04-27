package by.htp.car_catalog.web.util;

import javax.servlet.http.HttpServletRequest;

public class FormUtil {

	private FormUtil() {
	}

	public static boolean isPost(HttpServletRequest req) {

		return req.getMethod().toUpperCase().equals("POST");
	}

}
