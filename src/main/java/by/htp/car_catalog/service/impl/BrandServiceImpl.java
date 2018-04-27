package by.htp.car_catalog.service.impl;

import java.util.List;

import by.htp.car_catalog.dao.BrandCarDao;
import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.service.BrandService;

public class BrandServiceImpl implements BrandService {

	private BrandCarDao brandDao;

	public void setBrandDao(BrandCarDao brandDao) {
		this.brandDao = brandDao;
	}

	@Override
	public List<BrandCar> getAllBrands() {
		return brandDao.readAll();
	}

}
