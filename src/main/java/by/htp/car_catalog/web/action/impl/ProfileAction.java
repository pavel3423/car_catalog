package by.htp.car_catalog.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.car_catalog.dao.hbn.UserDaoHibernateImpl;
import by.htp.car_catalog.web.action.BaseAction;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

public class ProfileAction implements BaseAction {

    @Override
    public String executeAction(HttpServletRequest req) {
	req.setAttribute("users", new UserDaoHibernateImpl().readAll());
	return PAGE_USER_PROFILE;
    }

}
