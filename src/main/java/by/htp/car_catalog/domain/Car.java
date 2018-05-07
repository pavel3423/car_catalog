package by.htp.car_catalog.domain;

public class Car extends Entity {

    private static final long serialVersionUID = 1984566728743718380L;

    private BrandCar brandCar;
    private ModelCar modelCar;
    private String carClass;
    private String equipment;
    private int price;

    public Car() {
    }

    public Car(int id) {
	super(id);
    }

    public Car(int id, BrandCar brandCar, ModelCar modelCar, String carClass, String equipment, int price) {
	super(id);
	this.brandCar = brandCar;
	this.modelCar = modelCar;
	this.carClass = carClass;
	this.equipment = equipment;
	this.price = price;
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

    public String getEquipment() {
	return equipment;
    }

    public void setEquipment(String equipment) {
	this.equipment = equipment;
    }

    public int getPrice() {
	return price;
    }

    public void setPrice(int price) {
	this.price = price;
    }

    @Override
    public String toString() {
	return "Car [getId()=" + getId() + ", brandCar=" + brandCar + ", modelCar=" + modelCar + ", carClass="
		+ carClass + ", equipment=" + equipment + ", price=" + price + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((brandCar == null) ? 0 : brandCar.hashCode());
	result = prime * result + ((carClass == null) ? 0 : carClass.hashCode());
	result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
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
	if (equipment == null) {
	    if (other.equipment != null)
		return false;
	} else if (!equipment.equals(other.equipment))
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
