package by.htp.car_catalog.dao.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.UserDao;
import by.htp.car_catalog.domain.User;

@Component(value = "userDao")
public class UserDaoHibernateImpl implements UserDao {

    @Override
    public User create(User entity) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	session.save(entity);
	session.getTransaction().commit();
	session.close();

	return entity;
    }

    @Override
    public User read(int id) {
	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	User user = (User) session.load(User.class, id);
	session.close();

	return user;
    }

    @Override
    public User read(String login) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	Criteria criteria = session.createCriteria(User.class);
	criteria.add(Restrictions.eq("login", login));
	List<User> users = criteria.list();

	session.close();

	if (!users.isEmpty()) {

	    return users.get(0);
	} else {

	    return null;
	}
    }

    @Override
    public List<User> readAll() {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	List<User> users = session.createCriteria(User.class).list();
	session.close();
	return users;
    }

    @Override
    public void update(User entity) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	session.update(entity);
	session.getTransaction().commit();
	session.close();
    }

    @Override
    public void delete(User user) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	user.setRoleID(null);
	session.delete(user);
	session.getTransaction().commit();
	session.close();
    }

}
