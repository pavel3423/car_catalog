package by.htp.car_catalog;

import org.junit.Assert;
import org.junit.Test;

import by.htp.car_catalog.dao.hbn.CarDaoHibernateImpl;
import by.htp.car_catalog.domain.Car;

public class CarReadByBrandAndModelTest {

    @Test
    public void readByBrandAndModel() {
	Car car = new CarDaoHibernateImpl().readByBrandAndModel(null, null);
	Assert.assertNotNull("Cars not found", car);
    }
}
