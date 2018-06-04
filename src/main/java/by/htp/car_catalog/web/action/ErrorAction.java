package by.htp.car_catalog.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

@Controller
@RequestMapping("/error")
public class ErrorAction {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView error() {
	return new ModelAndView("error");
    }

    @RequestMapping(value = "/{errorNumber}", method = RequestMethod.GET)
    public String error(@PathVariable("errorNumber") String errorNumber, RedirectAttributes redirectAttributes) {
	redirectAttributes.addFlashAttribute(REQUEST_ERROR, errorNumber);
	return REDIRECT_TO + "/error";
    }

}
