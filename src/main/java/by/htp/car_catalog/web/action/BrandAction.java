package by.htp.car_catalog.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

@Controller
@RequestMapping("/brand")
public class BrandAction {

    @RequestMapping(method = RequestMethod.GET)
    public String brands() {

	return REDIRECT_TO + "/";
    }

}
