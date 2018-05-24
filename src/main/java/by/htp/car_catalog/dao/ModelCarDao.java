package by.htp.car_catalog.dao;

import java.util.List;

import by.htp.car_catalog.domain.ModelCar;

public interface ModelCarDao extends BaseDao<ModelCar> {

    List<ModelCar> readByBrand(String brand);

    ModelCar read(String brand, String model);

}
