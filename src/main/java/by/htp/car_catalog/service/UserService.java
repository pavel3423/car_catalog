package by.htp.car_catalog.service;

import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.web.util.exception.IOException.ValidateNullObjectException;

public interface UserService {

    User addUser(String login, String email, String password);

    User getUser(User user) throws ValidateNullObjectException;

}