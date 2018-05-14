package by.htp.car_catalog.web.action.spring_action;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullParamException;

@Controller
@SessionAttributes(types = User.class)
public class LoginAction {

    @Autowired
    private UserService userService;

    private static final String MSG_NO_USER = "Не удаётся войти. Пожалуйста проверьте правильность введённых данных.";

    public void setUserService(UserService userService) {
	this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

	return PAGE_USER_LOGIN;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String authorization(@RequestParam Map<String, String> params, Model model) {

	String login = params.get(REQUEST_PARAM_USER_LOGIN);
	String passwors = params.get(REQUEST_PARAM_USER_PASSWORD);

	try {

	    HttpRequestParamValidator.validateStringNotNull(login, passwors);
	    User user = userService.getUser(login, passwors);
	    HttpRequestParamValidator.validateObjectNotNull(user);

	    model.addAttribute(user);

	    return REDIRECT_TO + "profile";
	} catch (ValidateNullParamException e) {
	    model.addAttribute(REQUEST_MSG, MSG_NO_USER);
	    return PAGE_USER_LOGIN;
	}
    }
}
