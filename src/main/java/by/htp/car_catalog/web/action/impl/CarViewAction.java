package by.htp.car_catalog.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.car_catalog.domain.Car;
import by.htp.car_catalog.service.CarService;
import by.htp.car_catalog.web.action.BaseAction;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.List;

public class CarViewAction implements BaseAction {

    private final String CAR_NOT_FOUND = "Car not found: ";

    private CarService carService;

    public void setCarService(CarService carService) {
	this.carService = carService;
    }

    @Override
    public String executeAction(HttpServletRequest req) {

	String brand = req.getParameter(REQUEST_PARAM_CAR_BRAND);
	String model = req.getParameter(REQUEST_PARAM_CAR_MODEL);

	req.setAttribute(REQUEST_PARAM_CAR_BRAND, brand);
	req.setAttribute(REQUEST_PARAM_CAR_MODEL, model);
	List<Car> cars = carService.readByBrandAndModel(brand, model);

	if (!cars.isEmpty()) {

	    req.setAttribute(REQUEST_PARAM_CARS, cars);
	    return PAGE_CAR_VIEW;
	} else {

	    req.setAttribute(REQUEST_MSG, CAR_NOT_FOUND + brand + " " + model);
	    return PAGE_USER_ERROR;
	}
    }

}
