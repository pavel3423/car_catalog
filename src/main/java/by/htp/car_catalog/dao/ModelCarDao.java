package by.htp.car_catalog.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import by.htp.car_catalog.domain.ModelCar;

public interface ModelCarDao extends CrudRepository<ModelCar, Integer> {

    List<ModelCar> findBybrandID_brand(String brand);

    ModelCar findByBrandID_brandAndModel(String brand, String model);

}
