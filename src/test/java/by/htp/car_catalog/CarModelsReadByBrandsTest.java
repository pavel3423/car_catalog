package by.htp.car_catalog;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import by.htp.car_catalog.dao.hbn.ModelDaoHibernateImpl;
import by.htp.car_catalog.domain.ModelCar;

public class CarModelsReadByBrandsTest {

    @Test
    public void signinUser() {
	List<ModelCar> models = new ModelDaoHibernateImpl().readByBrand("Audi");
	Assert.assertNotNull("Models not found", models);
    }
}
