package by.htp.car_catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.BrandCarDao;
import by.htp.car_catalog.dao.ModelCarDao;
import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.service.ModelService;
import by.htp.car_catalog.service.util.uploadFile.SaveFile;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;
import by.htp.car_catalog.web.util.WebConstantDeclaration;

@Component(value = "modelService")
public class ModelServiceImpl implements ModelService {

    @Autowired
    @Qualifier(value = "modelDao")
    private ModelCarDao modelDao;

    @Autowired
    @Qualifier(value = "brandDao")
    private BrandCarDao brandDao;

    @Override
    public List<ModelCar> readByBrand(String brand) {

	return modelDao.readByBrand(brand);
    }

    @Override
    public void addModel(String brand, String model, UploadedFile uploadedFile) {

	uploadedFile.setPath(WebConstantDeclaration.IMAGE_ROOT + "\\car\\" + brand);
	String path = "/image/car&" + brand + "&" + SaveFile.saveFile(uploadedFile, model);

	BrandCar brandCar = brandDao.read(brand);
	modelDao.create(new ModelCar(0, brandCar, model, path));

    }

}
