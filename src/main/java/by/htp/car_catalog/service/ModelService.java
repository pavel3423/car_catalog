package by.htp.car_catalog.service;

import java.util.List;

import by.htp.car_catalog.domain.ModelCar;

public interface ModelService {

    List<ModelCar> readByBrand(String brand);
}
