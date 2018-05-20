package by.htp.car_catalog.dao.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.ModelCarDao;
import by.htp.car_catalog.domain.ModelCar;

@Component(value = "modelDao")
public class ModelDaoHibernateImpl implements ModelCarDao {

    @Override
    public ModelCar create(ModelCar entity) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	session.save(entity);
	session.getTransaction().commit();
	session.close();

	return entity;
    }

    @Override
    public ModelCar read(int id) {
	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	ModelCar model = (ModelCar) session.load(ModelCar.class, id);
	session.close();

	return model;
    }

    @Override
    public List<ModelCar> readAll() {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	List<ModelCar> models = session.createCriteria(ModelCar.class).list();
	session.close();
	return models;
    }

    @Override
    public void update(ModelCar entity) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	session.update(entity);
	session.getTransaction().commit();
	session.close();
    }

    @Override
    public void delete(ModelCar model) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	session.delete(model);
	session.getTransaction().commit();
	session.close();
    }

    @Override
    public List<ModelCar> readByBrand(String brand) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	Criteria criteria = session.createCriteria(ModelCar.class, "models_car");
	criteria.createAlias("models_car.brandID", "brands_car");
	criteria.add(Restrictions.eq("brands_car.brand", brand));
	criteria.addOrder(Order.asc("model"));

	List<ModelCar> models = criteria.list();

	session.close();

	return models;
    }

}
