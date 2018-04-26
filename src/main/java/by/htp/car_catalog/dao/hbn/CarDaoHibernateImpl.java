package by.htp.car_catalog.dao.hbn;

import java.util.List;

import org.hibernate.Session;

import by.htp.car_catalog.dao.CarDao;
import by.htp.car_catalog.domain.Car;

public class CarDaoHibernateImpl implements CarDao {

	@Override
	public void create(Car entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();

	}

	@Override
	public Car read(int id) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();

		return (Car) session.load(Car.class, id);
	}

	@Override
	public List<Car> readAll() {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		List<Car> cars = session.createCriteria(Car.class).list();

		return cars;
	}

	@Override
	public void update(Car entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();

	}

	@Override
	public void delete(int id) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(new Car(id));
		session.getTransaction().commit();

	}

}
