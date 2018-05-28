package by.htp.car_catalog.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.BrandCarDao;
import by.htp.car_catalog.dao.ModelCarDao;
import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.service.ModelService;
import by.htp.car_catalog.service.util.uploadFile.FileEditor;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.WebConstantDeclaration;
import by.htp.car_catalog.web.util.exception.runtimeException.RepeatorException;

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
    public void addModel(String brand, String model, UploadedFile uploadedFile) throws IOException {
	HttpRequestParamValidator.validateStringNotNull(brand, model);
	if (modelDao.read(brand, model) == null) {
	    uploadedFile.setPath(WebConstantDeclaration.IMAGE_ROOT + "\\car\\" + brand);
	    String path = "/image/car&" + brand + "&" + FileEditor.saveFile(uploadedFile, model);

	    BrandCar brandCar = brandDao.read(brand);
	    modelDao.create(new ModelCar(0, brandCar, model, path));
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
	String path = modelCar.getImage();

	if (model != newModel) {
	    modelCar.setModel(newModel);
	    modelCar.setImage(path.replace(model, newModel));
	    FileEditor.updateFileName(path, model, newModel);
	}

	if (uploadedFile.length() > 0) {
	    FileEditor.deleteFile(path);
	    uploadedFile.setPath(WebConstantDeclaration.IMAGE_ROOT + "\\car\\" + brand);
	    path = "/image/car&" + brand + "&" + FileEditor.saveFile(uploadedFile, brand);
	    modelCar.setImage(path);
	}

	modelDao.update(modelCar);

    }

}
