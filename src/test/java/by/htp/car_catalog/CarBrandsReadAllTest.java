package by.htp.car_catalog;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import by.htp.car_catalog.dao.hbn.BrandDaoHibernateImpl;
import by.htp.car_catalog.domain.BrandCar;

public class CarBrandsReadAllTest {

    @Test
    public void readAllCarBrands() {
	List<BrandCar> brands = new BrandDaoHibernateImpl().readAll();
	Assert.assertNotNull("Brands not found", brands);
    }
}
