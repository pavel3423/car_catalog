package by.htp.car_catalog.web.action.car_editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.htp.car_catalog.domain.Car;
import by.htp.car_catalog.service.CarService;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;
import by.htp.car_catalog.web.util.exception.IOException.UnknownCommandException;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/editor/")
public class CarEditorAction {

    private static final String CAR_UPDATED = "Vehicle data updated";
    private static final String CHECK_DATA = "Check the entered data";
    private static final String ERROR_SAVE = "Error saving image";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    @Qualifier(value = "carService")
    private CarService carService;

    @RequestMapping("{brand}/{model}")
    public ModelAndView carView(@PathVariable("brand") String brand, @PathVariable("model") String modelCar,
	    Model model) throws UnknownCommandException {

	if (carService.checkModel(brand, modelCar)) {
	    Car car = carService.readByBrandAndModel(brand, modelCar);
	    return new ModelAndView(PAGE_CARS_EDITOR, REQUEST_PARAM_CAR, car);
	}
	throw new UnknownCommandException();

    }

    @RequestMapping(value = "{brand}/{model}/carEdit", method = RequestMethod.POST)
    public String carEdit(@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
	    @PathVariable("brand") String brand, @PathVariable("model") String model,
	    @RequestParam Map<String, String> params, RedirectAttributes redirectAttributes, Locale locale)
	    throws IOException {

	Car car = carService.readByBrandAndModel(brand, model);
	if (car == null) {
	    car = carService.createCar(brand, model);
	}
	try {
	    carService.editCar(car, params, uploadedFile);

	    String message = messageSource.getMessage(CAR_UPDATED, null, locale);
	    redirectAttributes.addFlashAttribute(REQUEST_MSG, message);
	    return REDIRECT_TO + "/editor/" + brand + "/" + model;
	} catch (NumberFormatException e) {
	    String message = messageSource.getMessage(CHECK_DATA, null, locale);
	    redirectAttributes.addFlashAttribute(REQUEST_ERROR, message);
	    return REDIRECT_TO + "/editor/" + brand + "/" + model;
	}
    }

    @ExceptionHandler(IOException.class)
    public ModelAndView ioException(Exception ex, Locale locale) {

	String message = messageSource.getMessage(ERROR_SAVE, null, locale);
	return new ModelAndView(PAGE_ERROR, REQUEST_ERROR, message);
    }

}
