package by.htp.car_catalog.web.action;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.exception.IOException.ValidateNullParamException;

@Controller
@RequestMapping("/login")
public class LoginAction {

    private static final String MSG_NO_USER = "Can not login. Please check the correctness of the entered data";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login(@RequestParam Map<String, String> params, Model model) {

	return new ModelAndView(PAGE_USER_LOGIN, "command", new User());
    }

    @RequestMapping(method = RequestMethod.POST)
    private ModelAndView authorization(@ModelAttribute("user") User user, HttpSession session, Model model,
	    Locale locale, RedirectAttributes redirectAttributes)
	    throws UnsupportedEncodingException, GeneralSecurityException {
	try {

	    HttpRequestParamValidator.validateStringNotNull(user.getLogin(), user.getPassword());
	    user = userService.loginUser(user);

	    session.setAttribute(REQUEST_PARAM_USER, user);

	    return new ModelAndView(REDIRECT_TO + "profile");
	} catch (ValidateNullParamException e) {
	    String message = messageSource.getMessage(MSG_NO_USER, null, locale);
	    redirectAttributes.addFlashAttribute(REQUEST_MSG, message);
	    return new ModelAndView(REDIRECT_TO + "login");
	}
    }
}
