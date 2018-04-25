package by.htp.car_catalog.web.action.impl;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.car_catalog.web.action.BaseAction;

public class LogInAction implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest req) {

		return PAGE_USER_LOGIN;

	}
}
