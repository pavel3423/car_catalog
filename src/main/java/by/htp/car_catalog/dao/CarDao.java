package by.htp.car_catalog.dao;

import by.htp.car_catalog.domain.Car;

public interface CarDao extends BaseDao<Car> {

    Car readByBrandAndModel(String brand, String model);
}
