package by.htp.car_catalog.web.action.impl;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.web.action.BaseAction;
import by.htp.car_catalog.web.util.FormUtil;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.SessionUser;
import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullObjectException;
import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullParamException;
import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullStringException;

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

			HttpRequestParamValidator.validateStringNotNull(login, passwors);
			User user = userService.getUser(login, passwors);
			HttpRequestParamValidator.validateObjectNotNull(user);

			SessionUser.addUserSession(req, user, ACTION_NAME_PROFILE);

			return null;
		} catch (ValidateNullStringException e) {
			req.setAttribute(REQUEST_MSG, "Заполните все поля");
			return PAGE_USER_LOGIN;
		} catch (ValidateNullObjectException e) {
			req.setAttribute(REQUEST_MSG, "Пользователь с таким login или password не существует");
			return PAGE_USER_LOGIN;
		}
	}
}
