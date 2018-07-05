package by.htp.car_catalog.web.action;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.service.BrandService;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexAction {

    @Autowired
    @Qualifier(value = "brandService")
    private BrandService brandService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
	return "car/index";
    }

    @ResponseBody
    @RequestMapping(value = "json", method = RequestMethod.GET)
    public List<BrandCar> indexJson() {

	try {
	    return brandService.getAllBrands();
	} catch (JDBCConnectionException e) {
	    return null;
	}
    }

}
