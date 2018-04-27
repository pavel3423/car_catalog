package by.htp.car_catalog.dao;

import by.htp.car_catalog.domain.User;

public interface UserDao extends BaseDao<User> {

	User read(String login);

}
