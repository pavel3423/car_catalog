package by.htp.car_catalog.web.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import by.htp.car_catalog.web.action.ActionManagerContext;
import by.htp.car_catalog.web.action.BaseAction;
import by.htp.car_catalog.web.util.exception.runtimeException.RequestIOException;

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
		try {
			BaseAction baseAction = ActionManagerContext.getAction(action, webApplicationContext);

			if (action != null) {

				String page = baseAction.executeAction(req);
				String newAction = (String) req.getAttribute(REQUEST_PARAM_ACTION);

				if (newAction != null && !action.equals(newAction)) {
					resp.sendRedirect("do?action=" + newAction);

				} else {
					getRequestDispatcher(req, resp, page);
				}

			} else {
				sendErrorPage(req, resp, "Command not found");
			}
		} catch (RequestIOException | IOException e) {
			LogManager.getLogger().error("Error class MainServlet", e);
		} catch (NoSuchBeanDefinitionException e) {
			sendErrorPage(req, resp, "The command is not correct");
		} catch (JDBCConnectionException e) {
			LogManager.getLogger().error("No connection on JDBC driver", e);
			sendErrorPage(req, resp, "No connection to the database");
		}

	}

	private void getRequestDispatcher(HttpServletRequest req, HttpServletResponse resp, String page) {

		try {
			req.getRequestDispatcher(page).forward(req, resp);
		} catch (ServletException | IOException e) {
			throw new RequestIOException(e);
		}

	}

	private void sendErrorPage(HttpServletRequest req, HttpServletResponse resp, String errorMsg) {

		req.setAttribute(REQUEST_MSG, errorMsg);
		getRequestDispatcher(req, resp, PAGE_USER_ERROR);

	}

}
