package by.htp.car_catalog.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.car_catalog.web.action.BaseAction;
import by.htp.car_catalog.web.util.SessionUser;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

public class ProfileAction implements BaseAction {

    @Override
    public String executeAction(HttpServletRequest req) {
	req.setAttribute(REQUEST_PARAM_USER, SessionUser.getUserSession(req));
	return PAGE_USER_PROFILE;
    }

}
