package by.htp.car_catalog.web.action.car_editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import by.htp.car_catalog.web.util.exception.IOException.ValidateNullStringException;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/editor/")
public class CarEditorAction {

    private static final String CAR_UPDATED = "Данные об автомобиле обновлены";
    private static final String CHECK_DATA = "Проверьте введённые данные";
    private static final String ERROR_SAVE = "Ошибка сохранения изображения";

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
	    @RequestParam Map<String, String> params, RedirectAttributes redirectAttributes) throws IOException {

	Car car = carService.readByBrandAndModel(brand, model);
	if (car == null) {
	    car = carService.createCar(brand, model);
	}
	    carService.editCar(car, params, uploadedFile);

	    redirectAttributes.addFlashAttribute(REQUEST_MSG, CAR_UPDATED);
	    return REDIRECT_TO + "/editor/" + brand + "/" + model;
    }

    @ExceptionHandler(IOException.class)
    public ModelAndView ioException(Exception ex) {
	ModelAndView modelAndView = new ModelAndView(PAGE_ERROR);
	modelAndView.addObject("error", ERROR_SAVE);
	return modelAndView;
    }

}
