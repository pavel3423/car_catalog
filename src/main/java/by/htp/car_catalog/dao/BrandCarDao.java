package by.htp.car_catalog.dao;

import by.htp.car_catalog.domain.BrandCar;

public interface BrandCarDao extends BaseDao<BrandCar> {

    BrandCar read(String brand);

}
