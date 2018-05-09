package by.htp.car_catalog.web.action.impl;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;

import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.web.action.BaseAction;
import by.htp.car_catalog.web.util.FormUtil;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.SessionUser;
import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullParamException;

public class SignUpAction implements BaseAction {

    private static final String MSG_NO_REGISTRATION_USER = "Не удаётся зарегестрироваться. Пожалуйста проверьте правильность введённых данных.";
    private static final String MSG_USER_DUBLICATE = "Пользователь с этим именем или электронной почтой уже зарегестрирован.";

    private UserService userService;

    public void setUserService(UserService userService) {
	this.userService = userService;
    }

    @Override
    public String executeAction(HttpServletRequest req) {

	if (!FormUtil.isPost(req)) {

	    return PAGE_USER_SIGNUP;
	} else {

	    return registration(req);
	}
    }

    private String registration(HttpServletRequest req) {

	String login = req.getParameter(REQUEST_PARAM_USER_LOGIN);
	String email = req.getParameter(REQUEST_PARAM_USER_EMAIL);
	String password = req.getParameter(REQUEST_PARAM_USER_PASSWORD);

	try {
	    HttpRequestParamValidator.validateStringNotNull(login, email, password);
	    User user = userService.addUser(login, email, password);

	    SessionUser.addUserSession(req, user, ACTION_NAME_PROFILE);

	    return null;
	} catch (ValidateNullParamException e) {

	    req.setAttribute(REQUEST_MSG, MSG_NO_REGISTRATION_USER);
	    return PAGE_USER_SIGNUP;
	} catch (ConstraintViolationException e) {
	    req.setAttribute(REQUEST_MSG, MSG_USER_DUBLICATE);
	    return PAGE_USER_SIGNUP;
	}
    }

}
