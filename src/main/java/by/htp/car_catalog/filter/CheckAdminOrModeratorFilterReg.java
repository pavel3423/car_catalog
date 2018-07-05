package by.htp.car_catalog.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.web.filter.GenericFilterBean;

import by.htp.car_catalog.domain.Role;
import by.htp.car_catalog.domain.User;
import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

public class CheckAdminOrModeratorFilterReg extends GenericFilterBean {

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
		((HttpServletResponse) response).sendRedirect(req.getContextPath());
	    }

	} else {
	    ((HttpServletResponse) response).sendRedirect(req.getContextPath());
	}

    }
}
