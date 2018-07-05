package by.htp.car_catalog.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.UserDao;
import by.htp.car_catalog.domain.Role;
import by.htp.car_catalog.domain.User;
import by.htp.car_catalog.service.UserService;
import by.htp.car_catalog.service.util.sequrity.AES;
import by.htp.car_catalog.service.util.sequrity.Hash;
import by.htp.car_catalog.service.util.sequrity.Salt;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.exception.IOException.ValidateNullObjectException;

@Component(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(String login, String email, String password)
	    throws UnsupportedEncodingException, GeneralSecurityException {
	String salt = Salt.getSalt();
	String hash = Hash.getHash(password, salt);
	User user = new User(0, login, email, AES.encrypt(hash), salt, new Role(2, "user"));
	return userDao.save(user);
    }

    @Override
    public User loginUser(User user)
	    throws ValidateNullObjectException, UnsupportedEncodingException, GeneralSecurityException {

	User dataBaseUser = userDao.findByLogin(user.getLogin());
	HttpRequestParamValidator.validateObjectNotNull(dataBaseUser);

	String aes = AES.decrypt(dataBaseUser.getPassword());
	String hash = Hash.getHash(user.getPassword(), dataBaseUser.getSalt());
	if (hash.equals(aes)) {
	    return dataBaseUser;
	} else {
	    throw new ValidateNullObjectException();
	}
    }

    @Override
    public void updateUser(User user) {

	userDao.save(user);

    }

}