package by.htp.car_catalog.domain;

import java.util.List;

public class Car extends Entity {

    private static final long serialVersionUID = 1984566728743718380L;

    private BrandCar brandCar;
    private ModelCar modelCar;
    private String carClass;
    private int price;
    private List<Favorite> favorites;

    public Car() {
    }

    public Car(int id) {
	super(id);
    }

    public Car(int id, BrandCar brandCar, ModelCar modelCar, String carClass, int price, List<Favorite> favorites) {
	super(id);
	this.brandCar = brandCar;
	this.modelCar = modelCar;
	this.carClass = carClass;
	this.price = price;
	this.favorites = favorites;
    }

    public BrandCar getBrandCar() {
	return brandCar;
    }

    public void setBrandCar(BrandCar brandCar) {
	this.brandCar = brandCar;
    }

    public ModelCar getModelCar() {
	return modelCar;
    }

    public void setModelCar(ModelCar modelCar) {
	this.modelCar = modelCar;
    }

    public String getCarClass() {
	return carClass;
    }

    public void setCarClass(String carClass) {
	this.carClass = carClass;
    }

    public int getPrice() {
	return price;
    }

    public void setPrice(int price) {
	this.price = price;
    }

    public List<Favorite> getFavorites() {
	return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
	this.favorites = favorites;
    }

    @Override
    public String toString() {
	return "Car [getId()=" + getId() + ", brandCar=" + brandCar + ", modelCar=" + modelCar + ", carClass="
		+ carClass + ", price=" + price + ", favorites=" + favorites + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((brandCar == null) ? 0 : brandCar.hashCode());
	result = prime * result + ((carClass == null) ? 0 : carClass.hashCode());
	result = prime * result + ((favorites == null) ? 0 : favorites.hashCode());
	result = prime * result + ((modelCar == null) ? 0 : modelCar.hashCode());
	result = prime * result + price;
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
	Car other = (Car) obj;
	if (brandCar == null) {
	    if (other.brandCar != null)
		return false;
	} else if (!brandCar.equals(other.brandCar))
	    return false;
	if (carClass == null) {
	    if (other.carClass != null)
		return false;
	} else if (!carClass.equals(other.carClass))
	    return false;
	if (favorites == null) {
	    if (other.favorites != null)
		return false;
	} else if (!favorites.equals(other.favorites))
	    return false;
	if (modelCar == null) {
	    if (other.modelCar != null)
		return false;
	} else if (!modelCar.equals(other.modelCar))
	    return false;
	if (price != other.price)
	    return false;
	return true;
    }

}
