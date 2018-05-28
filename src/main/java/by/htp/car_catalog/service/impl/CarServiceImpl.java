package by.htp.car_catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.CarDao;
import by.htp.car_catalog.dao.ModelCarDao;
import by.htp.car_catalog.domain.Car;
import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.service.CarService;

@Component(value = "carService")
public class CarServiceImpl implements CarService {

    @Autowired
    @Qualifier(value = "carDao")
    private CarDao carDao;

    @Autowired
    @Qualifier(value = "modelDao")
    private ModelCarDao modelDao;

    @Override
    public Car readByBrandAndModel(String brand, String model) {

	return carDao.readByBrandAndModel(brand, model);
    }

    @Override
    public boolean checkModel(String brand, String model) {
	ModelCar modelCar = modelDao.read(brand, model);
	return modelCar != null;
    }

}
