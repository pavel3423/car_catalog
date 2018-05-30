package by.htp.car_catalog.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.htp.car_catalog.domain.Role;
import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileAction {

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String profile(HttpSession session, Model model) {
	User user = (User) session.getAttribute(REQUEST_PARAM_USER);
	if (user != null) {
	    model.addAttribute(REQUEST_PARAM_USER, user);
	    checkRoles(user, model);

	    return PAGE_USER_PROFILE;
	} else {

	    return REDIRECT_TO + "login";
	}
    }

    @RequestMapping(method = RequestMethod.POST)
    public String editProfile(HttpSession session, @RequestParam String email, @RequestParam String password,
	    RedirectAttributes redirectAttributes) {

	User user = (User) session.getAttribute(REQUEST_PARAM_USER);

	user.setEmail(email);

	user.setPassword(password);

	userService.updateUser(user);
	return REDIRECT_TO + "profile";

    }

    private static void checkRoles(User user, Model model) {
	Role role = user.getRoleID();
	if (role.getId() == 1 || role.getId() == 3) {
	    model.addAttribute(REQUEST_PARAM_MODERATOR, true);
	}

	if (role.getId() == 1) {
	    model.addAttribute(REQUEST_PARAM_ADMIN, true);
	}
    }

}
