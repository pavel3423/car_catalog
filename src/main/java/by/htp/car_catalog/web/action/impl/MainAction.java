package by.htp.car_catalog.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.car_catalog.service.BrandService;
import by.htp.car_catalog.web.action.BaseAction;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

public class MainAction implements BaseAction {

	private BrandService brandService;

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	@Override
	public String executeAction(HttpServletRequest req) {
		req.setAttribute(REQUEST_PARAM_ALL_BRANDS, brandService.getAllBrands());
		return PAGE_USER_MAIN;
	}

}
