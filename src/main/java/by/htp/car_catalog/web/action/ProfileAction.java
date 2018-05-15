package by.htp.car_catalog.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.car_catalog.domain.User;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileAction {

    @RequestMapping(method = RequestMethod.GET)
    public String profile(HttpSession session, Model model) {
	User user = (User) session.getAttribute(REQUEST_PARAM_USER);
	if (user != null) {
	    model.addAttribute(REQUEST_PARAM_USER, user);
	    return PAGE_USER_PROFILE;
	} else {

	    return REDIRECT_TO + "login";
	}
    }

}
