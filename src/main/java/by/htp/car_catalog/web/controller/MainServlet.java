package by.htp.car_catalog.web.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import by.htp.car_catalog.web.action.ActionManagerContext;
import by.htp.car_catalog.web.action.BaseAction;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = -8124305332353370991L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) {

		ServletContext servletContext = req.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);

		String action = req.getParameter(REQUEST_PARAM_ACTION);
		BaseAction baseAction = ActionManagerContext.getAction(action, webApplicationContext);

		try {

			if (action != null) {
				String page = baseAction.executeAction(req);
				req.getRequestDispatcher(page).forward(req, resp);
			} else {
				resp.getWriter().println("Incorrect Action");
			}

		} catch (ServletException | IOException e) {
			LogManager.getLogger().error("Error class MainServlet", e);
		}

	}

}
