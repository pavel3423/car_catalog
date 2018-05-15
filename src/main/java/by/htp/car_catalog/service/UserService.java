package by.htp.car_catalog.service;

import by.htp.car_catalog.domain.User;

public interface UserService {

    User addUser(String login, String email, String password);

    User getUser(User user);

}