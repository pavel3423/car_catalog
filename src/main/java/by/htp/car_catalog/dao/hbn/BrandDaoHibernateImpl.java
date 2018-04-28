package by.htp.car_catalog.dao.hbn;

import java.util.List;

import org.hibernate.Session;

import by.htp.car_catalog.dao.BrandCarDao;
import by.htp.car_catalog.domain.BrandCar;

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
	public List<BrandCar> readAll() {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		List<BrandCar> brands = session.createCriteria(BrandCar.class).list();

		return brands;
	}

	@Override
	public void update(BrandCar entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();

	}

	@Override
	public void delete(int id) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(new BrandCar(id, null));
		session.getTransaction().commit();

	}

}
