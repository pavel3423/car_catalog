package by.htp.car_catalog.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.htp.car_catalog.dao.BrandCarDao;
import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.service.BrandService;
import by.htp.car_catalog.service.util.uploadFile.SaveFile;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;
import by.htp.car_catalog.web.util.HttpRequestParamValidator;
import by.htp.car_catalog.web.util.WebConstantDeclaration;

@Component(value = "brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    @Qualifier(value = "brandDao")
    private BrandCarDao brandDao;

    @Override
    public void addBrand(String brand, UploadedFile uploadedFile) throws IOException {
	HttpRequestParamValidator.validateStringNotNull(brand);

	uploadedFile.setPath(WebConstantDeclaration.IMAGE_ROOT + "\\car");

	String path = "/image/car&" + SaveFile.saveFile(uploadedFile, brand);
	brandDao.create(new BrandCar(0, brand, path));

    }

    @Override
    public List<BrandCar> getAllBrands() {
	return brandDao.readAll();
    }

}
