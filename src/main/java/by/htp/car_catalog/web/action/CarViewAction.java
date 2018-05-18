package by.htp.car_catalog.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.car_catalog.domain.Car;
import by.htp.car_catalog.service.CarService;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.List;

@Controller
@RequestMapping("/{brand}/{model}")
public class CarViewAction {

    private static final String CAR_NOT_FOUND = "Car not found: ";

    @Autowired
    @Qualifier(value = "carService")
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String carView(@PathVariable("brand") String brand, @PathVariable("model") String modelCar, Model model) {

	List<Car> cars = carService.readByBrandAndModel(brand, modelCar);

	if (!cars.isEmpty()) {

	    model.addAttribute(REQUEST_PARAM_CARS, cars);
	    return PAGE_CAR_VIEW;
	} else {

	    model.addAttribute(REQUEST_MSG, CAR_NOT_FOUND + brand + " " + modelCar);
	    return PAGE_USER_ERROR;
	}
    }

}
