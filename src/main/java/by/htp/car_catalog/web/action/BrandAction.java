package by.htp.car_catalog.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.service.BrandService;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandAction {

    @Autowired
    private BrandService brandService;

    public void setBrandService(BrandService brandService) {
	this.brandService = brandService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String brands(Model model) {

	List<BrandCar> brands = brandService.getAllBrands();
	model.addAttribute(REQUEST_PARAM_ALL_BRANDS, brands);

	return PAGE_CAR_BRANDS;
    }

}
