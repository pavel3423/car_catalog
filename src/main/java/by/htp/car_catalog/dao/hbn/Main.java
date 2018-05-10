package by.htp.car_catalog.dao.hbn;

import by.htp.car_catalog.domain.Role;
import by.htp.car_catalog.domain.User;

public class Main {

    public static void main(String[] args) {

	User user = new User(0, "test2", "test@test2", "test", new Role(2, "user"));
	UserDaoHibernateImpl dao = new UserDaoHibernateImpl();
	dao.create(user);

    }

}
