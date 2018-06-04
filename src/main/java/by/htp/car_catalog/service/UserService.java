package by.htp.car_catalog.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.web.util.exception.IOException.ValidateNullObjectException;

public interface UserService {

    User addUser(String login, String email, String password)
	    throws UnsupportedEncodingException, GeneralSecurityException;

    User loginUser(User user)
	    throws ValidateNullObjectException, UnsupportedEncodingException, GeneralSecurityException;

    void updateUser(User user);

}