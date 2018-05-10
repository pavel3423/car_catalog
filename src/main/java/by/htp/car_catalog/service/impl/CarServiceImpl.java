package by.htp.car_catalog.service.impl;

import java.util.List;

import by.htp.car_catalog.dao.CarDao;
import by.htp.car_catalog.domain.Car;
import by.htp.car_catalog.service.CarService;

public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public void setCarDao(CarDao carDao) {
	this.carDao = carDao;
    }

    @Override
    public List<Car> readByBrandAndModel(String brand, String model) {

	return carDao.readByBrandAndModel(brand, model);
    }

}
