package by.htp.car_catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.UserDao;
import by.htp.car_catalog.domain.Role;
import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.exception.IOException.ValidateNullObjectException;

@Component(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;

    @Override
    public User addUser(String login, String email, String password) {

	User user = new User(0, login, email, password, new Role(2, "user"));
	return userDao.create(user);
    }

    @Override
    public User getUser(User user) throws ValidateNullObjectException {

	user = userDao.read(user.getLogin(), user.getPassword());
	HttpRequestParamValidator.validateObjectNotNull(user);

	return user;

    }

    @Override
    public void updateUser(User user) {
	userDao.update(user);

    }

}