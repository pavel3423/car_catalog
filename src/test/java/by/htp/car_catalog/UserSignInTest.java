package by.htp.car_catalog;

import org.junit.Assert;
import org.junit.Test;

import by.htp.car_catalog.dao.hbn.UserDaoHibernateImpl;
import by.htp.car_catalog.domain.Role;
import by.htp.car_catalog.domain.User;

public class UserSignInTest {

    @Test
    public void signinUser() {
	User user = new User(0, "test", "test@test", "test", new Role(2, "user"));
	UserDaoHibernateImpl dao = new UserDaoHibernateImpl();
	dao.create(user);
	Assert.assertNotEquals("id user equals 0", 0, user.getId());
	dao.delete(user);
	user = dao.read("test", "test");
	Assert.assertNull("String test found in database", user);
    }
}
