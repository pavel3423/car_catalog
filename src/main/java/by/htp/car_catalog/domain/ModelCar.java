package by.htp.car_catalog.domain;

import java.util.List;

public class ModelCar extends Entity {

    private static final long serialVersionUID = 6379681683695619732L;

    private BrandCar brandCar;
    private String model;
    private List<Car> cars;

    public ModelCar() {
    }

    public ModelCar(int id) {
	super(id);
    }

    public ModelCar(int id, BrandCar brandCar, String model, List<Car> cars) {
	super(id);
	this.brandCar = brandCar;
	this.model = model;
	this.cars = cars;
    }

    public BrandCar getBrandCar() {
	return brandCar;
    }

    public void setBrandCar(BrandCar brandCar) {
	this.brandCar = brandCar;
    }

    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public List<Car> getCars() {
	return cars;
    }

    public void setCars(List<Car> cars) {
	this.cars = cars;
    }

    @Override
    public String toString() {
	return "ModelCar [getId()=" + getId() + ", brandCar=" + brandCar + ", model=" + model + ", cars=" + cars + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((brandCar == null) ? 0 : brandCar.hashCode());
	result = prime * result + ((cars == null) ? 0 : cars.hashCode());
	result = prime * result + ((model == null) ? 0 : model.hashCode());
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
	ModelCar other = (ModelCar) obj;
	if (brandCar == null) {
	    if (other.brandCar != null)
		return false;
	} else if (!brandCar.equals(other.brandCar))
	    return false;
	if (cars == null) {
	    if (other.cars != null)
		return false;
	} else if (!cars.equals(other.cars))
	    return false;
	if (model == null) {
	    if (other.model != null)
		return false;
	} else if (!model.equals(other.model))
	    return false;
	return true;
    }

}
