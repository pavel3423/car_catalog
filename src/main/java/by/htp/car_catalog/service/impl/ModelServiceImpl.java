package by.htp.car_catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.ModelCarDao;
import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.service.ModelService;

@Component(value = "modelService")
public class ModelServiceImpl implements ModelService {

    @Autowired
    @Qualifier(value = "modelDao")
    private ModelCarDao modelDao;

    @Override
    public List<ModelCar> readByBrand(String brand) {

	return modelDao.readByBrand(brand);
    }

}
