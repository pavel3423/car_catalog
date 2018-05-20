package by.htp.car_catalog.web.action.car_panel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.car_catalog.service.BrandService;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

@Controller
@RequestMapping("/panel/")
public class BrandEditAction {

    @Autowired
    @Qualifier(value = "brandService")
    BrandService brandService;

    @RequestMapping(value = "addBrand", method = RequestMethod.GET)
    public String brandAdd() {

	return PAGE_PANEL_BRAND_ADD;
    }

    @RequestMapping(value = "addBrand", method = RequestMethod.POST)
    public String brandAdd(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, @RequestParam String brand) {

	brandService.addBrand(brand, uploadedFile);
	return REDIRECT_TO + "add";
    }

}
