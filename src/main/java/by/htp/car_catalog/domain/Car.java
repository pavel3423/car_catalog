package by.htp.car_catalog.domain;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "cars")
public class Car extends Entity {

    private static final long serialVersionUID = 1984566728743718380L;

    private BrandCar brandID;
    private ModelCar modelID;
    @Column(name = "carClass")
    private String carClass;
    @Column(name = "equipment")
    private String equipment;
    @Column(name = "price")
    private int price;

    public Car() {
    }

    public Car(int id) {
	super(id);
    }

    public Car(int id, BrandCar brandID, ModelCar modelID, String carClass, String equipment, int price) {
	super(id);
	this.brandID = brandID;
	this.modelID = modelID;
	this.carClass = carClass;
	this.equipment = equipment;
	this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Override
    public int getId() {
	return super.getId();
    }

    @Override
    public void setId(int id) {
	super.setId(id);
    }

    @ManyToOne
    @JoinColumn(name = "brandID", nullable = true)
    public BrandCar getBrandID() {
	return brandID;
    }

    public void setBrandID(BrandCar brandID) {
	this.brandID = brandID;
    }

    @ManyToOne
    @JoinColumn(name = "modelID", nullable = true)
    public ModelCar getModelID() {
	return modelID;
    }

    public void setModelID(ModelCar modelID) {
	this.modelID = modelID;
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
	return "Car [getId()=" + getId() + ", brandID=" + brandID + ", modelID=" + modelID + ", carClass=" + carClass
		+ ", equipment=" + equipment + ", price=" + price + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((brandID == null) ? 0 : brandID.hashCode());
	result = prime * result + ((carClass == null) ? 0 : carClass.hashCode());
	result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
	result = prime * result + ((modelID == null) ? 0 : modelID.hashCode());
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
	if (brandID == null) {
	    if (other.brandID != null)
		return false;
	} else if (!brandID.equals(other.brandID))
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
	if (modelID == null) {
	    if (other.modelID != null)
		return false;
	} else if (!modelID.equals(other.modelID))
	    return false;
	if (price != other.price)
	    return false;
	return true;
    }

}
