package by.htp.car_catalog.dao.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.CarDao;
import by.htp.car_catalog.domain.Car;

@Component(value = "carDao")
public class CarDaoHibernateImpl implements CarDao {

    @Override
    public Car create(Car entity) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	session.save(entity);
	session.getTransaction().commit();

	return entity;
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
    public void delete(Car car) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	session.delete(car);
	session.getTransaction().commit();

    }

    @Override
    public List<Car> readByBrandAndModel(String brand, String model) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	Criteria criteria = session.createCriteria(Car.class, "cars");
	criteria.createAlias("cars.modelID", "models_car").createAlias("models_car.brandID", "brands_car");
	criteria.add(Restrictions.eq("models_car.model", model)).add(Restrictions.eq("brands_car.brand", brand));
	criteria.addOrder(Order.asc("price"));

	List<Car> cars = criteria.list();

	session.close();

	return cars;
    }

}
