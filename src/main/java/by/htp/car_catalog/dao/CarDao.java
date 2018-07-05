package by.htp.car_catalog.dao;

import org.springframework.data.repository.CrudRepository;

import by.htp.car_catalog.domain.Car;

public interface CarDao extends CrudRepository<Car, Integer> {

    Car findByModelID_BrandID_BrandAndModelID_Model(String brand, String model);
}
