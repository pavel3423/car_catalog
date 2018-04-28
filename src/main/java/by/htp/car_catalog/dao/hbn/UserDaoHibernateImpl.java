package by.htp.car_catalog.dao.hbn;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import by.htp.car_catalog.dao.UserDao;
import by.htp.car_catalog.domain.User;

public class UserDaoHibernateImpl implements UserDao {

	@Override
	public void create(User entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();

	}

	@Override
	public User read(int id) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();

		return (User) session.load(User.class, id);
	}

	@Override
	public User read(String login, String password) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.createCriteria(User.class).add(Restrictions.eq("login", login)).list();
		List<User> users = session.createCriteria(User.class).add(Restrictions.eq("login", login))
				.add(Restrictions.eq("password", password)).list();

		if (users.size() > 0) {

			return users.get(0);
		} else {

			return null;
		}
	}

	@Override
	public List<User> readAll() {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		List<User> users = session.createCriteria(User.class).list();

		return users;
	}

	@Override
	public void update(User entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();

	}

	@Override
	public void delete(int id) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(new User(id));
		session.getTransaction().commit();

	}

}
