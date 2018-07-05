package by.htp.car_catalog.web.action;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout")
public class LogoutAction {

    @RequestMapping(method = RequestMethod.GET)
    public String logout(HttpSession session) {

	session.invalidate();

	return REDIRECT_TO + "/";
    }

}