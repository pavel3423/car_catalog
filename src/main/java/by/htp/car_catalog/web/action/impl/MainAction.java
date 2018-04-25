package by.htp.car_catalog.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.car_catalog.web.action.BaseAction;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

public class MainAction implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest req) {

		return PAGE_USER_MAIN;

	}

}
