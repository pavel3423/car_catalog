package by.htp.car_catalog.web.action.impl;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.car_catalog.web.action.BaseAction;

public class LogOutAction implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest req) {

		req.getSession().invalidate();
		req.setAttribute(REQUEST_PARAM_ACTION, ACTION_NAME_MAIN);

		return null;
	}

}
