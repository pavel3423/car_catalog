package by.htp.car_catalog.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import by.htp.car_catalog.domain.Role;
import by.htp.car_catalog.domain.User;
import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

public class CheckModeratorFilter implements Filter {

    private static final String NO_ACCESS_RIGHTS = "У вас нет прав доступа к данному ресурсу";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest) request;
	HttpSession session = req.getSession();
	User user = (User) session.getAttribute(REQUEST_PARAM_USER);
	if (user != null) {

	    Role role = user.getRoleID();
	    if (role.getId() == 1 || role.getId() == 3) {
		chain.doFilter(request, response);
	    } else {
		getError(request, response);
	    }

	} else {
	    getError(request, response);
	}

    }

    private static void getError(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/page/error.jsp");
	request.setAttribute(REQUEST_ERROR, NO_ACCESS_RIGHTS);
	dispatcher.forward(request, response);
    }

}
