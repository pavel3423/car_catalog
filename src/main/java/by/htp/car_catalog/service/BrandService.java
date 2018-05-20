package by.htp.car_catalog.service;

import java.io.IOException;
import java.util.List;

import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;

public interface BrandService {

    List<BrandCar> getAllBrands();

    void addBrand(String brand, UploadedFile uploadedFile) throws IOException;

}
