package by.htp.car_catalog.web.action;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.exception.runtimeException.ValidateNullParamException;

@Controller
@RequestMapping("/signup")
public class SignupAction {

    private static final String MSG_NO_REGISTRATION_USER = "Не удаётся зарегестрироваться. Пожалуйста проверьте правильность введённых данных.";
    private static final String MSG_USER_DUBLICATE = "Пользователь с этим именем или электронной почтой уже зарегестрирован.";

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String signup() {

	return PAGE_USER_SIGNUP;
    }

    @RequestMapping(method = RequestMethod.POST)
    private String registration(@RequestParam Map<String, String> params, HttpSession session, Model model) {

	String login = params.get(REQUEST_PARAM_USER_LOGIN);
	String email = params.get(REQUEST_PARAM_USER_EMAIL);
	String password = params.get(REQUEST_PARAM_USER_PASSWORD);

	try {
	    HttpRequestParamValidator.validateStringNotNull(login, email, password);
	    User user = userService.addUser(login, email, password);

	    session.setAttribute(REQUEST_PARAM_USER, user);
	    return REDIRECT_TO + "profile";
	} catch (ValidateNullParamException e) {

	    model.addAttribute(REQUEST_MSG, MSG_NO_REGISTRATION_USER);
	    return PAGE_USER_SIGNUP;
	} catch (ConstraintViolationException e) {

	    model.addAttribute(REQUEST_MSG, MSG_USER_DUBLICATE);
	    return PAGE_USER_SIGNUP;
	}
    }

}