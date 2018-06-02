package by.htp.car_catalog.web.action;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.exception.IOException.ValidateNullParamException;

@Controller
@RequestMapping("/signup")
public class SignupAction {

    private static final String MSG_NO_REGISTRATION_USER = "Can not register. Please check the correctness of the entered data";
    private static final String MSG_USER_DUBLICATE = "A user with this name or e-mail is already registered";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String signup() {

	return PAGE_USER_SIGNUP;
    }

    @RequestMapping(method = RequestMethod.POST)
    private String registration(@RequestParam Map<String, String> params, HttpSession session, Model model,
	    Locale locale) {

	String login = params.get(REQUEST_PARAM_USER_LOGIN);
	String email = params.get(REQUEST_PARAM_USER_EMAIL);
	String password = params.get(REQUEST_PARAM_USER_PASSWORD);

	try {
	    HttpRequestParamValidator.validateStringNotNull(login, email, password);
	    User user = userService.addUser(login, email, password);

	    session.setAttribute(REQUEST_PARAM_USER, user);
	    return REDIRECT_TO + "profile";
	} catch (ValidateNullParamException e) {

	    String message = messageSource.getMessage(MSG_NO_REGISTRATION_USER, null, locale);
	    model.addAttribute(REQUEST_MSG, message);
	    return PAGE_USER_SIGNUP;
	} catch (ConstraintViolationException e) {

	    String message = messageSource.getMessage(MSG_USER_DUBLICATE, null, locale);
	    model.addAttribute(REQUEST_MSG, message);
	    return PAGE_USER_SIGNUP;
	}
    }

}