package by.htp.car_catalog.service.impl;

import by.htp.car_catalog.dao.UserDao;
import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User addUser(String login, String email, String password) {

		userDao.create(new User(0, login, email, password, 2));

		return userDao.read(login, password);
	}

	@Override
	public User getUser(String login, String password) {

		return userDao.read(login, password);
	}

}
