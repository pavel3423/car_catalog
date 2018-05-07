package by.htp.car_catalog.service.impl;

import by.htp.car_catalog.dao.UserDao;
import by.htp.car_catalog.domain.Role;
import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
    }

    @Override
    public User addUser(String login, String email, String password) {
	User user = new User(0, login, email, password, new Role(2, "User"));
	userDao.create(user);

	return user;
    }

    @Override
    public User getUser(String login, String password) {

	return userDao.read(login, password);
    }

}
