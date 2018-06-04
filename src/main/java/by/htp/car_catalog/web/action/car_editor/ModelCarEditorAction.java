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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

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

    private static final String MODEL_ADDED = "Model added";
    private static final String MODEL_UPDATED = "The model card has been updated";
    private static final String MODEL_DELETED = "Model and car removed";
    private static final String CHECK_DATA = "Check the entered data";
    private static final String ERROR_SAVE = "Error saving image";

    @Autowired
    private MessageSource messageSource;

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
	    @RequestParam String model, RedirectAttributes redirectAttributes, Locale locale) {
	try {

	    modelService.addModel(brand, model, uploadedFile);
	    String message = messageSource.getMessage(MODEL_ADDED, null, locale);
	    redirectAttributes.addFlashAttribute(REQUEST_MSG, message);

	} catch (IOException | RepeatorException e) {
	    String message = messageSource.getMessage(CHECK_DATA, null, locale);
	    redirectAttributes.addFlashAttribute(REQUEST_ERROR, message);
	}
	return REDIRECT_TO + EDITOR_WITH_SLASH + brand;
    }

    @RequestMapping(value = "/{brand}/{model}/edit", method = RequestMethod.POST)
    public String modelEdit(@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
	    @PathVariable("brand") String brand, @PathVariable("model") String model, @RequestParam String newModel,
	    RedirectAttributes redirectAttributes, Locale locale) throws IOException {

	try {
	    modelService.editModel(brand, model, newModel, uploadedFile);

	    String message = messageSource.getMessage(MODEL_UPDATED, null, locale);
	    redirectAttributes.addFlashAttribute(REQUEST_MSG, message);
	    return REDIRECT_TO + EDITOR_WITH_SLASH + brand + "/" + newModel;

	} catch (ValidateNullStringException | FileNotFoundException e) {
	    String message = messageSource.getMessage(CHECK_DATA, null, locale);
	    redirectAttributes.addFlashAttribute(REQUEST_ERROR, message);
	    return REDIRECT_TO + EDITOR_WITH_SLASH + brand + "/" + model;
	}

    }

    @RequestMapping(value = "/{brand}/{model}/delete", method = RequestMethod.POST)
    public String modelAndCarDelete(@PathVariable("brand") String brand, @PathVariable("model") String model,
	    RedirectAttributes redirectAttributes, Locale locale) {

	modelService.deleteModelAndCar(brand, model);

	String message = messageSource.getMessage(MODEL_DELETED, null, locale);
	redirectAttributes.addFlashAttribute(REQUEST_MSG, message);
	return REDIRECT_TO + EDITOR_WITH_SLASH + brand;

    }

    @ExceptionHandler(IOException.class)
    public ModelAndView ioException(Exception ex, Locale locale) {

	String message = messageSource.getMessage(ERROR_SAVE, null, locale);
	return new ModelAndView(PAGE_ERROR, REQUEST_ERROR, message);
    }

}
