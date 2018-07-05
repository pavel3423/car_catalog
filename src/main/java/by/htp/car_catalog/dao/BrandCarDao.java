package by.htp.car_catalog.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.htp.car_catalog.domain.BrandCar;

@Repository
public interface BrandCarDao extends CrudRepository<BrandCar, Integer> {

    BrandCar findByBrand(String brand);

}
