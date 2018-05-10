package by.htp.car_catalog.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.service.ModelService;
import by.htp.car_catalog.web.action.BaseAction;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.List;

public class ModelsAction implements BaseAction {

    private final String BRAND_NOT_FOUND = "Brand not found";

    private ModelService modelService;

    public void setModelService(ModelService modelService) {
	this.modelService = modelService;
    }

    @Override
    public String executeAction(HttpServletRequest req) {
	String brand = req.getParameter(REQUEST_PARAM_CAR_BRAND);
	req.setAttribute(REQUEST_PARAM_CAR_BRAND, brand);
	List<ModelCar> models = modelService.readByBrand(brand);
	if (models.isEmpty()) {
	    req.setAttribute(REQUEST_MSG, BRAND_NOT_FOUND);
	    return PAGE_USER_ERROR;
	}
	req.setAttribute(REQUEST_PARAM_CAR_MODELS, models);

	return PAGE_CAR_MODELS;
    }

}
