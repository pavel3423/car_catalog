package by.htp.car_catalog.service.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.BrandCarDao;
import by.htp.car_catalog.dao.CarDao;
import by.htp.car_catalog.dao.ModelCarDao;
import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.domain.Car;
import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.service.ModelService;
import by.htp.car_catalog.service.util.uploadFile.FileEditor;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.exception.runtimeException.RepeatorException;

@Component(value = "modelService")
public class ModelServiceImpl implements ModelService {

    @Autowired
    @Qualifier(value = "fileEditor")
    private FileEditor fileEditor;

    @Autowired

    private ModelCarDao modelDao;

    @Autowired
    private BrandCarDao brandDao;

    @Autowired
    private CarDao carDao;

    @Override
    public List<ModelCar> readByBrand(String brand) {

	return modelDao.findBybrandID_brand(brand);
    }

    @Override
    public void addModel(String brand, String model, UploadedFile uploadedFile) throws IOException {
	HttpRequestParamValidator.validateStringNotNull(brand, model);

	if (modelDao.findByBrandID_brandAndModel(brand, model) == null) {
	    BrandCar brandCar = brandDao.findByBrand(brand);
	    
	    ModelCar modelCar = modelDao.save(new ModelCar(0, brandCar, model, fileEditor.saveFile(uploadedFile)));
	    carDao.save(new Car(0, modelCar));
	} else {
	    throw new RepeatorException();
	}
    }

    @Override
    public boolean checkBrand(String brand) {
	BrandCar brandCar = brandDao.findByBrand(brand);
	return brandCar != null;

    }

    @Override
    public void editModel(String brand, String model, String newModel, UploadedFile uploadedFile) throws IOException {

	HttpRequestParamValidator.validateStringNotNull(newModel);
	ModelCar modelCar = modelDao.findByBrandID_brandAndModel(brand, model);

	if (model != newModel) {
	    modelCar.setModel(newModel);
	}

	if (uploadedFile.length() > 0) {
	    fileEditor.deleteFile(modelCar.getImage());
	    modelCar.setImage(fileEditor.saveFile(uploadedFile));
	}

	modelDao.save(modelCar);

    }

    @Override
    public void deleteModelAndCar(String brand, String model) {
	Car car = carDao.findByModelID_BrandID_BrandAndModelID_Model(brand, model);
	ModelCar modelCar = car.getModelID();
	fileEditor.deleteFile(car.getImage());
	fileEditor.deleteFile(modelCar.getImage());
	modelDao.delete(modelCar);
    }

    @Override
    public void deleteAllModelAndCarImage(String brand) {

	List<ModelCar> modelsCar = modelDao.findBybrandID_brand(brand);
	for (Iterator<ModelCar> iterator = modelsCar.iterator(); iterator.hasNext();) {
	    ModelCar modelCar = iterator.next();
	    Car car = carDao.findByModelID_BrandID_BrandAndModelID_Model(brand, modelCar.getModel());
	    fileEditor.deleteFile(car.getImage());
	    fileEditor.deleteFile(modelCar.getImage());
	}
    }

}
