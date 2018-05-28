package by.htp.car_catalog.service;

import by.htp.car_catalog.domain.Car;

public interface CarService {

    Car readByBrandAndModel(String brand, String model);

    boolean checkModel(String brand, String model);
}
