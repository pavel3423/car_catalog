package by.htp.car_catalog.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.service.BrandService;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/main")
public class MainAction {

    @Autowired
    private ServletContext context;

    public void setServletContext(ServletContext servletContext) {
	this.context = servletContext;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getBrands(ModelMap model) {

	WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.context);
	BrandService brandService = (BrandService) webApplicationContext.getBean("brandService");

	List<BrandCar> brands = brandService.getAllBrands();
	model.addAttribute(REQUEST_PARAM_ALL_BRANDS, brands);

	return "main";
    }

}
