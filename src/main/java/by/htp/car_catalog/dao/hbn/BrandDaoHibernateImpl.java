package by.htp.car_catalog.dao.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.BrandCarDao;
import by.htp.car_catalog.domain.BrandCar;

@Component(value = "brandDao")
public class BrandDaoHibernateImpl implements BrandCarDao {

    @Override
    public BrandCar create(BrandCar entity) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	session.save(entity);
	session.getTransaction().commit();

	return entity;
    }

    @Override
    public BrandCar read(int id) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();

	return (BrandCar) session.load(BrandCar.class, id);
    }

    @Override
    public BrandCar read(String brand) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	Criteria criteria = session.createCriteria(BrandCar.class);
	criteria.add(Restrictions.eq("brand", brand));
	List<BrandCar> brands = criteria.list();

	session.close();

	if (!brands.isEmpty()) {

	    return brands.get(0);
	} else {

	    return null;
	}
    }

    @Override
    public List<BrandCar> readAll() {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	Criteria criteria = session.createCriteria(BrandCar.class);
	criteria.addOrder(Order.asc("brand"));

	return criteria.list();
    }

    @Override
    public void update(BrandCar entity) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	session.update(entity);
	session.getTransaction().commit();

    }

    @Override
    public void delete(BrandCar brandCar) {

	Session session = SessionFactoryManager.getSessionFactory().openSession();
	session.beginTransaction();
	session.delete(brandCar);
	session.getTransaction().commit();

    }

}
