package by.htp.car_catalog.web.util.exception;

import org.apache.logging.log4j.LogManager;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import by.htp.car_catalog.web.util.exception.IOException.UnknownCommandException;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JDBCConnectionException.class)
    public ModelAndView jdbcConnectionException(Exception ex) {
	LogManager.getLogger().error("No connection on JDBC driver", ex);
	ModelAndView modelAndView = new ModelAndView(PAGE_ERROR);
	modelAndView.addObject(REQUEST_ERROR, "No connection on JDBC driver");
	return modelAndView;
    }

    @ExceptionHandler(UnknownCommandException.class)
    public ModelAndView unknownCommandException(Exception ex) {
	ModelAndView modelAndView = new ModelAndView(PAGE_ERROR);
	modelAndView.addObject(REQUEST_ERROR, "Unknown command error");
	return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleBadFileNameException(Exception ex) {
	LogManager.getLogger().error("Unknown command", ex);
	ModelAndView modelAndView = new ModelAndView(PAGE_ERROR);
	modelAndView.addObject(REQUEST_ERROR, "Unknown error");
	return modelAndView;
    }
}
