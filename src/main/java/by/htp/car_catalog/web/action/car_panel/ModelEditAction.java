package by.htp.car_catalog.web.action.car_panel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.service.BrandService;
import by.htp.car_catalog.service.ModelService;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;
import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullStringException;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/panel/")
public class ModelEditAction {

    private static final String MODEL_ADDED = "Модель добавлена";

    @Autowired
    @Qualifier(value = "brandService")
    BrandService brandService;

    @Autowired
    @Qualifier(value = "modelService")
    ModelService modelService;

    @RequestMapping(value = "addModel", method = RequestMethod.GET)
    public String brandAdd(Model model) {

	List<BrandCar> brands = brandService.getAllBrands();
	model.addAttribute(REQUEST_PARAM_ALL_BRANDS, brands);

	return PAGE_PANEL_MODEL_ADD;
    }

    @RequestMapping(value = "addModel", method = RequestMethod.POST)
    public String brandAdd(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, @RequestParam String brand,
	    @RequestParam String model, RedirectAttributes redirectAttributes) throws IOException {

	modelService.addModel(brand, model, uploadedFile);

	redirectAttributes.addFlashAttribute(REQUEST_MSG, MODEL_ADDED);
	return REDIRECT_TO + "addModel";
    }

    @ExceptionHandler(value = { FileNotFoundException.class, ValidateNullStringException.class })
    public String fileException(Exception ex, RedirectAttributes redirectAttributes) {

	redirectAttributes.addFlashAttribute(REQUEST_ERROR, "Проверьте введённые данные");
	return REDIRECT_TO + "addModel";
    }

    @ExceptionHandler(IOException.class)
    public ModelAndView ioException(Exception ex) {
	ModelAndView modelAndView = new ModelAndView(PAGE_ERROR);
	modelAndView.addObject("error", "Ошибка сохранения изображения");
	return modelAndView;
    }

}
