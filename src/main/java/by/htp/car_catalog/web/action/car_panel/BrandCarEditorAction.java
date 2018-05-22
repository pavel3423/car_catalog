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
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;
import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullStringException;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/editor")
public class BrandCarEditorAction {

    private static final String BRAND_ADDED = "Бренд добавлен";
    private static final String BRAND_DELETED = "Бренд удалён";
    private static final String BRAND_UPDATED = "Бренд обновлён";
    private static final String BRAND_NO_DATA = "Нет данных для обновления";
    private static final String CHECK_DATA = "Проверьте введённые данные";
    private static final String ERROR_SAVE = "Ошибка сохранения изображения";

    @Autowired
    @Qualifier(value = "brandService")
    BrandService brandService;

    @RequestMapping(method = RequestMethod.GET)
    public String brandEdit(Model model) {

	List<BrandCar> brands = brandService.getAllBrands();
	model.addAttribute(REQUEST_PARAM_ALL_BRANDS, brands);

	return PAGE_CAR_EDITOR;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String brandAdd(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, @RequestParam String brand,
	    RedirectAttributes redirectAttributes) throws IOException {

	brandService.addBrand(brand, uploadedFile);

	redirectAttributes.addFlashAttribute(REQUEST_MSG, BRAND_ADDED);
	return REDIRECT_TO + "/editor";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String brandDelete(@RequestParam String brand, RedirectAttributes redirectAttributes) {

	brandService.deleteBrand(brand);
	redirectAttributes.addFlashAttribute(REQUEST_MSG, BRAND_DELETED);

	return REDIRECT_TO + "/editor";

    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String brandEdit(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, @RequestParam String brand,
	    @RequestParam String newBrand, RedirectAttributes redirectAttributes) throws IOException {
	try {

	    brandService.editBrand(brand, newBrand, uploadedFile);

	    redirectAttributes.addFlashAttribute(REQUEST_MSG, BRAND_UPDATED);
	    return REDIRECT_TO + "/editor/" + newBrand;

	} catch (ValidateNullStringException e) {
	    redirectAttributes.addFlashAttribute(REQUEST_ERROR, CHECK_DATA);
	    return REDIRECT_TO + "/editor/" + brand;
	}

    }

    @ExceptionHandler(value = { FileNotFoundException.class, ValidateNullStringException.class })
    public String fileException(Exception ex, RedirectAttributes redirectAttributes) {

	redirectAttributes.addFlashAttribute(REQUEST_ERROR, CHECK_DATA);
	return REDIRECT_TO + "/editor";
    }

    @ExceptionHandler(IOException.class)
    public ModelAndView ioException(Exception ex) {
	ModelAndView modelAndView = new ModelAndView(PAGE_ERROR);
	modelAndView.addObject("error", ERROR_SAVE);
	return modelAndView;
    }

}
