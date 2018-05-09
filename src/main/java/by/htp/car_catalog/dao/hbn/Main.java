package by.htp.car_catalog.dao.hbn;

import by.htp.car_catalog.domain.Role;
import by.htp.car_catalog.domain.User;

public class Main {

    public static void main(String[] args) {

	User user = (User) new UserDaoHibernateImpl()
		.create(new User(0, "lfcgbhfghjj", "ffghdfgjjh", "fgfghfghjjh", new Role(2, "user")));

	System.out.println(user);
    }

}
