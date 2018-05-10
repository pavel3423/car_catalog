package by.htp.car_catalog.service.impl;

import java.util.List;

import by.htp.car_catalog.dao.ModelCarDao;
import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.service.ModelService;

public class ModelServiceImpl implements ModelService {

    private ModelCarDao modelDao;

    public void setModelDao(ModelCarDao modelDao) {
	this.modelDao = modelDao;
    }

    @Override
    public List<ModelCar> readByBrand(String brand) {

	return modelDao.readByBrand(brand);
    }

}
