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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.service.ModelService;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;
import by.htp.car_catalog.web.util.exception.IOException.UnknownCommandException;
import by.htp.car_catalog.web.util.exception.IOException.ValidateNullStringException;
import by.htp.car_catalog.web.util.exception.runtimeException.RepeatorException;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

@Controller
@RequestMapping("/editor/")
public class ModelCarEditorAction {

    private static final String MODEL_ADDED = "Модель добавлена";
    private static final String MODEL_UPDATED = "Карточка модели обновлена";
    private static final String MODEL_DELETED = "Модель и автомобиль удалены";
    private static final String CHECK_DATA = "Проверьте введённые данные";
    private static final String ERROR_SAVE = "Ошибка сохранения изображения";

    @Autowired
    @Qualifier(value = "modelService")
    ModelService modelService;

    @RequestMapping(value = "{brand}", method = RequestMethod.GET)
    public String modelEdit(@PathVariable("brand") String brand, Model model) throws UnknownCommandException {
	if (modelService.checkBrand(brand)) {
	    List<ModelCar> models = modelService.readByBrand(brand);

	    model.addAttribute(REQUEST_PARAM_CAR_MODELS, models);

	    return PAGE_CAR_MODEL_EDITOR;
	} else {
	    throw new UnknownCommandException();
	}
    }

    @RequestMapping(value = "{brand}", method = RequestMethod.POST)
    public String modelAdd(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, @RequestParam String brand,
	    @RequestParam String model, RedirectAttributes redirectAttributes) {
	try {

	    modelService.addModel(brand, model, uploadedFile);
	    redirectAttributes.addFlashAttribute(REQUEST_MSG, MODEL_ADDED);

	} catch (IOException | RepeatorException e) {
	    redirectAttributes.addFlashAttribute(REQUEST_ERROR, CHECK_DATA);
	}
	return REDIRECT_TO + "/editor/" + brand;
    }

    @RequestMapping(value = "/{brand}/{model}/edit", method = RequestMethod.POST)
    public String modelEdit(@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
	    @PathVariable("brand") String brand, @PathVariable("model") String model, @RequestParam String newModel,
	    RedirectAttributes redirectAttributes) throws IOException {

	try {
	    modelService.editModel(brand, model, newModel, uploadedFile);

	    redirectAttributes.addFlashAttribute(REQUEST_MSG, MODEL_UPDATED);
	    return REDIRECT_TO + "/editor/" + brand + "/" + newModel;

	} catch (ValidateNullStringException | FileNotFoundException e) {
	    redirectAttributes.addFlashAttribute(REQUEST_ERROR, CHECK_DATA);
	    return REDIRECT_TO + "/editor/" + brand + "/" + model;
	}

    }

    @RequestMapping(value = "/{brand}/{model}/delete", method = RequestMethod.POST)
    public String modelAndCarDelete(@PathVariable("brand") String brand, @PathVariable("model") String model,
	    RedirectAttributes redirectAttributes) throws IOException {

	modelService.deleteModelAndCar(brand, model);

	redirectAttributes.addFlashAttribute(REQUEST_MSG, MODEL_DELETED);
	return REDIRECT_TO + "/editor/" + brand;

    }

    @ExceptionHandler(IOException.class)
    public ModelAndView ioException(Exception ex) {
	ModelAndView modelAndView = new ModelAndView(PAGE_ERROR);
	modelAndView.addObject("error", ERROR_SAVE);
	return modelAndView;
    }

}
