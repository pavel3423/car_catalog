package by.htp.car_catalog.dao;

import org.springframework.data.repository.CrudRepository;

import by.htp.car_catalog.domain.User;

public interface UserDao extends CrudRepository<User, Integer> {

    User findByLogin(String login);

}
