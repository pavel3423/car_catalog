package by.htp.car_catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.BrandCarDao;
import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.service.BrandService;

@Component(value = "brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    @Qualifier(value = "brandDao")
    private BrandCarDao brandDao;

    @Override
    public List<BrandCar> getAllBrands() {
	return brandDao.readAll();
    }

}
