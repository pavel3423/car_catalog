package by.htp.car_catalog.web.action;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.exception.IOException.ValidateNullParamException;

@Controller
@RequestMapping("/login")
public class LoginAction {

    private static final String MSG_NO_USER = "Не удаётся войти. Пожалуйста проверьте правильность введённых данных.";

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login(@RequestParam Map<String, String> params, Model model) {

	return new ModelAndView(PAGE_USER_LOGIN, "command", new User());
    }

    @RequestMapping(method = RequestMethod.POST)
    private ModelAndView authorization(@ModelAttribute("user") User user, HttpSession session, Model model) {
	try {

	    HttpRequestParamValidator.validateStringNotNull(user.getLogin(), user.getPassword());
	    user = userService.getUser(user);

	    session.setAttribute(REQUEST_PARAM_USER, user);

	    return new ModelAndView(REDIRECT_TO + "profile");
	} catch (ValidateNullParamException e) {
	    model.addAttribute(REQUEST_MSG, MSG_NO_USER);
	    return new ModelAndView(PAGE_USER_LOGIN, "command", new User());
	}
    }
}
