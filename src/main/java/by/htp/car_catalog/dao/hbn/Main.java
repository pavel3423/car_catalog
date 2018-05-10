package by.htp.car_catalog.dao.hbn;

import java.util.List;

import by.htp.car_catalog.domain.ModelCar;

public class Main {

    public static void main(String[] args) {

	ModelDaoHibernateImpl dao = new ModelDaoHibernateImpl();
	List<ModelCar> models = dao.readByBrand("BMW");
	System.out.println(models);
    }

}
