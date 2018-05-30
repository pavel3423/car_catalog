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
    @Qualifier(value = "modelDao")
    private ModelCarDao modelDao;

    @Autowired
    @Qualifier(value = "brandDao")
    private BrandCarDao brandDao;

    @Autowired
    @Qualifier(value = "carDao")
    private CarDao carDao;

    @Override
    public List<ModelCar> readByBrand(String brand) {

	return modelDao.readByBrand(brand);
    }

    @Override
    public void addModel(String brand, String model, UploadedFile uploadedFile) throws IOException {
	HttpRequestParamValidator.validateStringNotNull(brand, model);

	if (modelDao.read(brand, model) == null) {
	    BrandCar brandCar = brandDao.read(brand);
	    ModelCar modelCar = modelDao.create(new ModelCar(0, brandCar, model, FileEditor.saveFile(uploadedFile)));
	    carDao.create(new Car(0, modelCar));
	} else {
	    throw new RepeatorException();
	}
    }

    @Override
    public boolean checkBrand(String brand) {
	BrandCar brandCar = brandDao.read(brand);
	return brandCar != null;

    }

    @Override
    public void editModel(String brand, String model, String newModel, UploadedFile uploadedFile) throws IOException {

	HttpRequestParamValidator.validateStringNotNull(newModel);
	ModelCar modelCar = modelDao.read(brand, model);

	if (model != newModel) {
	    modelCar.setModel(newModel);
	}

	if (uploadedFile.length() > 0) {
	    FileEditor.deleteFile(modelCar.getImage());
	    modelCar.setImage(FileEditor.saveFile(uploadedFile));
	}

	modelDao.update(modelCar);

    }

    @Override
    public void deleteModelAndCar(String brand, String model) {
	Car car = carDao.readByBrandAndModel(brand, model);
	ModelCar modelCar = car.getModelID();
	FileEditor.deleteFile(car.getImage());
	FileEditor.deleteFile(modelCar.getImage());
	modelDao.delete(modelCar);
    }

    @Override
    public void deleteAllModelAndCarImage(String brand) {

	List<ModelCar> modelsCar = modelDao.readByBrand(brand);
	for (Iterator<ModelCar> iterator = modelsCar.iterator(); iterator.hasNext();) {
	    ModelCar modelCar = iterator.next();
	    Car car = carDao.readByBrandAndModel(brand, modelCar.getModel());
	    FileEditor.deleteFile(car.getImage());
	    FileEditor.deleteFile(modelCar.getImage());
	}
    }

}
