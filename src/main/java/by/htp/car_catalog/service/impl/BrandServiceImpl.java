package by.htp.car_catalog.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.BrandCarDao;
import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.service.BrandService;
import by.htp.car_catalog.service.util.uploadFile.FileEditor;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.WebConstantDeclaration;
import by.htp.car_catalog.web.util.exception.runtimeException.RepeatorException;

@Component(value = "brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    @Qualifier(value = "brandDao")
    private BrandCarDao brandDao;

    @Override
    public void addBrand(String brand, UploadedFile uploadedFile) throws IOException {
	HttpRequestParamValidator.validateStringNotNull(brand);

	if (brandDao.read(brand) == null) {
	    uploadedFile.setPath(WebConstantDeclaration.IMAGE_ROOT + "\\car");

	    String path = "/image/car&" + FileEditor.saveFile(uploadedFile, brand);
	    brandDao.create(new BrandCar(0, brand, path));

	}else {
	    throw new RepeatorException();
	}
    }

    @Override
    public List<BrandCar> getAllBrands() {
	return brandDao.readAll();
    }

    @Override
    public void deleteBrand(String brand) throws IOException {

	BrandCar brandCar = brandDao.read(brand);
	FileEditor.deleteFile(brandCar.getImage());
	FileEditor.deletePackage(brand);
	brandDao.delete(brandCar);
    }

    @Override
    public void editBrand(String brand, String newBrand, UploadedFile uploadedFile) throws IOException {

	HttpRequestParamValidator.validateStringNotNull(newBrand);
	BrandCar brandCar = brandDao.read(brand);
	String path = brandCar.getImage();

	if (brand != newBrand) {
	    brandCar.setBrand(newBrand);
	    brandCar.setImage(path.replace(brand, newBrand));
	    FileEditor.updateFileName(path, brand, newBrand);
	}

	if (uploadedFile.length() > 0) {
	    FileEditor.deleteFile(path);
	    uploadedFile.setPath(WebConstantDeclaration.IMAGE_ROOT + "\\car");
	    path = "/image/car&" + FileEditor.saveFile(uploadedFile, brand);
	    brandCar.setImage(path);
	}

	brandDao.update(brandCar);
    }

}
