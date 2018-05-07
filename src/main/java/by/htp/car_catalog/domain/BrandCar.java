package by.htp.car_catalog.domain;

import java.util.List;

public class BrandCar extends Entity {

    private static final long serialVersionUID = -6226794434941096791L;

    private String brand;
    private List<ModelCar> models;
    private List<Car> cars;

    public BrandCar() {
    }

    public BrandCar(int id, String brand, List<ModelCar> models, List<Car> cars) {
	super(id);
	this.brand = brand;
	this.models = models;
	this.cars = cars;
    }

    public String getBrand() {
	return brand;
    }

    public void setBrand(String brand) {
	this.brand = brand;
    }

    public List<ModelCar> getModels() {
	return models;
    }

    public void setModels(List<ModelCar> models) {
	this.models = models;
    }

    public List<Car> getCars() {
	return cars;
    }

    public void setCars(List<Car> cars) {
	this.cars = cars;
    }

    @Override
    public String toString() {
	return "BrandCar [getId()=" + getId() + ", brand=" + brand + ", models=" + models + ", cars=" + cars + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((brand == null) ? 0 : brand.hashCode());
	result = prime * result + ((cars == null) ? 0 : cars.hashCode());
	result = prime * result + ((models == null) ? 0 : models.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	BrandCar other = (BrandCar) obj;
	if (brand == null) {
	    if (other.brand != null)
		return false;
	} else if (!brand.equals(other.brand))
	    return false;
	if (cars == null) {
	    if (other.cars != null)
		return false;
	} else if (!cars.equals(other.cars))
	    return false;
	if (models == null) {
	    if (other.models != null)
		return false;
	} else if (!models.equals(other.models))
	    return false;
	return true;
    }

}
