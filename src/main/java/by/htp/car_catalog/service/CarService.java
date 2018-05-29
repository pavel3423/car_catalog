package by.htp.car_catalog.service;

import java.io.IOException;
import java.util.Map;

import by.htp.car_catalog.domain.Car;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;

public interface CarService {
    Car createCar(String brand, String model);

    Car readByBrandAndModel(String brand, String model);

    boolean checkModel(String brand, String model);

    Car editCar(Car car, Map<String, String> params, UploadedFile uploadedFile) throws IOException;
}
