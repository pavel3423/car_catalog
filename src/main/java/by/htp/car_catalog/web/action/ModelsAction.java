package by.htp.car_catalog.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.service.ModelService;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.List;

@Controller
@RequestMapping("/{brand}")
public class ModelsAction {

    private static final String BRAND_NOT_FOUND = "Brand not found: ";

    @Autowired
    @Qualifier(value = "modelService")
    private ModelService modelService;

    @RequestMapping(method = RequestMethod.GET)
    public String models(@PathVariable("brand") String brand, Model model) {

	List<ModelCar> models = modelService.readByBrand(brand);

	if (!models.isEmpty()) {

	    model.addAttribute(REQUEST_PARAM_CAR_MODELS, models);
	    return PAGE_CAR_MODELS;
	} else {

	    model.addAttribute(REQUEST_ERROR, BRAND_NOT_FOUND + brand);
	    return PAGE_ERROR;
	}
    }

}
