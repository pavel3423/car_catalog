package by.htp.car_catalog.service;

import java.util.List;

import by.htp.car_catalog.domain.Car;

public interface CarService {

    List<Car> readByBrandAndModel(String brand, String model);

}
