package by.htp.car_catalog.service;

import java.io.IOException;
import java.util.List;

import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;

public interface ModelService {

    List<ModelCar> readByBrand(String brand);

    void addModel(String brand, String model, UploadedFile uploadedFile) throws IOException;
}
