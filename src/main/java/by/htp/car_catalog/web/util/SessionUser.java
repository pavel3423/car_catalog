package by.htp.car_catalog.web.util;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.car_catalog.domain.User;

public class SessionUser {

	private SessionUser() {
	}

	public static void addUserSession(HttpServletRequest req, User user, String action) {

		HttpSession session = req.getSession();
		session.setAttribute(REQUEST_PARAM_USER, user);
		req.setAttribute(REQUEST_PARAM_ACTION, action);

	}

}
