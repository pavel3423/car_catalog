package by.htp.car_catalog.web.action.impl;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.web.action.BaseAction;
import by.htp.car_catalog.web.util.FormUtil;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.ValidateNullParamException;

public class LogInAction implements BaseAction {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String executeAction(HttpServletRequest req) {

		if (!FormUtil.isPost(req)) {

			return PAGE_USER_LOGIN;
		} else {

			return authorization(req);
		}
	}

	private String authorization(HttpServletRequest req) {

		String login = req.getParameter(REQUEST_PARAM_USER_LOGIN);
		String passwors = req.getParameter(REQUEST_PARAM_USER_PASSWORD);

		try {

			HttpRequestParamValidator.validateRequestParamNotNull(login, passwors);
			User user = userService.getUser(login, passwors);
			HttpRequestParamValidator.validateRequestParamNotNull(user);

			HttpSession session = req.getSession();
			session.setAttribute(REQUEST_PARAM_USER, user);
			req.setAttribute(REQUEST_PARAM_ACTION, ACTION_NAME_PROFILE);

			return null;
		} catch (ValidateNullParamException e) {

			req.setAttribute(REQUEST_MSG, "Неверное имя пользователя или пароль");
			return PAGE_USER_LOGIN;
		}
	}
}
