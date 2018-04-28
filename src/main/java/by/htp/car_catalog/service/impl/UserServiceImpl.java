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
	public User getUser(String login, String password) {

		return userDao.read(login, password);
	}

}
