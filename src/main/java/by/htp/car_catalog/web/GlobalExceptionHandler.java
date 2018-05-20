package by.htp.car_catalog.web;

import org.apache.logging.log4j.LogManager;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JDBCConnectionException.class)
    public ModelAndView jdbcConnectionException(Exception ex) {
	LogManager.getLogger().error("No connection on JDBC driver", ex);
	ModelAndView modelAndView = new ModelAndView(PAGE_ERROR);
	modelAndView.addObject("error", "No connection on JDBC driver");
	return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleBadFileNameException(Exception ex) {
	LogManager.getLogger().error("Unknown error", ex);
	ModelAndView modelAndView = new ModelAndView(PAGE_ERROR);
	modelAndView.addObject("error", "Unknown error");
	return modelAndView;
    }
}
