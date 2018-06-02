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

import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.service.BrandService;
import by.htp.car_catalog.service.ModelService;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;
import by.htp.car_catalog.web.util.exception.IOException.ValidateNullStringException;
import by.htp.car_catalog.web.util.exception.runtimeException.RepeatorException;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/editor")
public class BrandCarEditorAction {

    private static final String BRAND_ADDED = "Brand added";
    private static final String BRAND_DELETED = "Brand deleted";
    private static final String BRAND_UPDATED = "Brand updated";
    private static final String CHECK_DATA = "Check the entered data";
    private static final String ERROR_SAVE = "Error saving image";

    @Autowired
    MessageSource messageSourse;

    @Autowired
    @Qualifier(value = "brandService")
    BrandService brandService;

    @Autowired
    @Qualifier(value = "modelService")
    ModelService modelService;

    @RequestMapping(method = RequestMethod.GET)
    public String brandEdit(Model model) {

	List<BrandCar> brands = brandService.getAllBrands();
	model.addAttribute(REQUEST_PARAM_ALL_BRANDS, brands);

	return PAGE_CAR_EDITOR;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String brandAdd(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, @RequestParam String brand,
	    RedirectAttributes redirectAttributes, Locale locale) throws IOException {

	brandService.addBrand(brand, uploadedFile);

	String message = messageSourse.getMessage(BRAND_ADDED, null, locale);
	redirectAttributes.addFlashAttribute(REQUEST_MSG, message);
	return REDIRECT_TO + "/editor";
    }

    @RequestMapping(value = "/{brand}/delete", method = RequestMethod.POST)
    public String brandDelete(@PathVariable("brand") String brand, RedirectAttributes redirectAttributes, Locale locale)
	    throws IOException {

	modelService.deleteAllModelAndCarImage(brand);

	brandService.deleteBrand(brand);
	String message = messageSourse.getMessage(BRAND_DELETED, null, locale);
	redirectAttributes.addFlashAttribute(REQUEST_MSG, message);

	return REDIRECT_TO + "/editor";

    }

    @RequestMapping(value = "/{brand}/edit", method = RequestMethod.POST)
    public String brandEdit(@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
	    @PathVariable("brand") String brand, @RequestParam String newBrand, RedirectAttributes redirectAttributes,
	    Locale locale) throws IOException {
	try {

	    brandService.editBrand(brand, newBrand, uploadedFile);

	    String message = messageSourse.getMessage(BRAND_UPDATED, null, locale);
	    redirectAttributes.addFlashAttribute(REQUEST_MSG, message);
	    return REDIRECT_TO + "/editor/" + newBrand;

	} catch (ValidateNullStringException e) {
	    String message = messageSourse.getMessage(CHECK_DATA, null, locale);
	    redirectAttributes.addFlashAttribute(REQUEST_ERROR, message);
	    return REDIRECT_TO + "/editor/" + brand;
	}

    }

    @ExceptionHandler(value = { FileNotFoundException.class, ValidateNullStringException.class,
	    RepeatorException.class })
    public String fileException(Exception ex, RedirectAttributes redirectAttributes, Locale locale) {

	String message = messageSourse.getMessage(CHECK_DATA, null, locale);
	redirectAttributes.addFlashAttribute(REQUEST_ERROR, message);
	return REDIRECT_TO + "/editor";
    }

    @ExceptionHandler(IOException.class)
    public ModelAndView ioException(Exception ex, Locale locale) {
	ModelAndView modelAndView = new ModelAndView(PAGE_ERROR);

	String message = messageSourse.getMessage(ERROR_SAVE, null, locale);
	modelAndView.addObject(REQUEST_ERROR, message);
	return modelAndView;
    }

}
