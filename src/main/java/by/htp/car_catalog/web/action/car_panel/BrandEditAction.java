package by.htp.car_catalog.web.action.car_panel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.htp.car_catalog.service.BrandService;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;
import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullStringException;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/panel/")
public class BrandEditAction {

    private static final String BRAND_ADDED = "Бренд добавлен.";
    private static final String CHECK_DATA = "Проверьте введённые данные";
    private static final String ERROR_SAVE = "Ошибка сохранения изображения";

    @Autowired
    @Qualifier(value = "brandService")
    BrandService brandService;

    @RequestMapping(value = "addBrand", method = RequestMethod.GET)
    public String brandAdd() {

	return PAGE_PANEL_BRAND_ADD;
    }

    @RequestMapping(value = "addBrand", method = RequestMethod.POST)
    public String brandAdd(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, @RequestParam String brand,
	    RedirectAttributes redirectAttributes) throws IOException {

	brandService.addBrand(brand, uploadedFile);

	redirectAttributes.addFlashAttribute(REQUEST_MSG, BRAND_ADDED);
	return REDIRECT_TO + "addBrand";
    }

    @ExceptionHandler(value = { FileNotFoundException.class, ValidateNullStringException.class })
    public String fileException(Exception ex, RedirectAttributes redirectAttributes) {

	redirectAttributes.addFlashAttribute(REQUEST_ERROR, CHECK_DATA);
	return REDIRECT_TO + "addBrand";
    }

    @ExceptionHandler(IOException.class)
    public ModelAndView ioException(Exception ex) {
	ModelAndView modelAndView = new ModelAndView(PAGE_ERROR);
	modelAndView.addObject("error", ERROR_SAVE);
	return modelAndView;
    }

}
