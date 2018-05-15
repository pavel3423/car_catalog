package by.htp.car_catalog.service.impl;

import by.htp.car_catalog.dao.UserDao;
import by.htp.car_catalog.domain.Role;
import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
    }

    @Override
    public User addUser(String login, String email, String password) {

	User user = new User(0, login, email, password, new Role(2, "user"));
	return userDao.create(user);
    }

    @Override
    public User getUser(User user) {

	user = userDao.read(user.getLogin(), user.getPassword());
	HttpRequestParamValidator.validateObjectNotNull(user);

	return user;

    }

}