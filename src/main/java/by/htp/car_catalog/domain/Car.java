package by.htp.car_catalog.domain;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "cars")
public class Car extends Entity {

    private static final long serialVersionUID = 1984566728743718380L;

    private ModelCar modelID;
    @Column(name = "year")
    private int year;
    @Column(name = "bodyType")
    private String bodyType;
    @Column(name = "length")
    private int length;
    @Column(name = "width")
    private int width;
    @Column(name = "height")
    private int height;
    @Column(name = "base")
    private int base;
    @Column(name = "numberOfDoors")
    private int numberOfDoors;
    @Column(name = "clearance")
    private int clearance;
    @Column(name = "trunk")
    private int trunk;
    @Column(name = "volumeOfTheTank")
    private int volumeOfTheTank;
    @Column(name = "numberOfPlaces")
    private int numberOfPlaces;
    @Column(name = "price")
    private int price;
    @Column(name = "image")
    private String image;

    public Car() {
    }

    public Car(int id) {
	super(id);
    }

    public Car(int id, ModelCar modelID) {
	super(id);
	this.modelID = modelID;
    }

    public Car(int id, ModelCar modelID, int year, String bodyType, int length, int width, int height, int base,
	    int numberOfDoors, int clearance, int trunk, int volumeOfTheTank, int numberOfPlaces, int price,
	    String image) {
	super(id);
	this.modelID = modelID;
	this.year = year;
	this.bodyType = bodyType;
	this.length = length;
	this.width = width;
	this.height = height;
	this.base = base;
	this.numberOfDoors = numberOfDoors;
	this.clearance = clearance;
	this.trunk = trunk;
	this.volumeOfTheTank = volumeOfTheTank;
	this.numberOfPlaces = numberOfPlaces;
	this.price = price;
	this.image = image;
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
    @JoinColumn(name = "modelID", nullable = true)
    public ModelCar getModelID() {
	return modelID;
    }

    public void setModelID(ModelCar modelID) {
	this.modelID = modelID;
    }

    public int getYear() {
	return year;
    }

    public void setYear(int year) {
	this.year = year;
    }

    public String getBodyType() {
	return bodyType;
    }

    public void setBodyType(String bodyType) {
	this.bodyType = bodyType;
    }

    public int getLength() {
	return length;
    }

    public void setLength(int length) {
	this.length = length;
    }

    public int getWidth() {
	return width;
    }

    public void setWidth(int width) {
	this.width = width;
    }

    public int getHeight() {
	return height;
    }

    public void setHeight(int height) {
	this.height = height;
    }

    public int getBase() {
	return base;
    }

    public void setBase(int base) {
	this.base = base;
    }

    public int getNumberOfDoors() {
	return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
	this.numberOfDoors = numberOfDoors;
    }

    public int getClearance() {
	return clearance;
    }

    public void setClearance(int clearance) {
	this.clearance = clearance;
    }

    public int getTrunk() {
	return trunk;
    }

    public void setTrunk(int trunk) {
	this.trunk = trunk;
    }

    public int getVolumeOfTheTank() {
	return volumeOfTheTank;
    }

    public void setVolumeOfTheTank(int volumeOfTheTank) {
	this.volumeOfTheTank = volumeOfTheTank;
    }

    public int getNumberOfPlaces() {
	return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
	this.numberOfPlaces = numberOfPlaces;
    }

    public int getPrice() {
	return price;
    }

    public void setPrice(int price) {
	this.price = price;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    @Override
    public String toString() {
	return "Car [getId()=" + getId() + ", modelID=" + modelID + ", year=" + year + ", bodyType=" + bodyType
		+ ", length=" + length + ", width=" + width + ", height=" + height + ", base=" + base
		+ ", numberOfDoors=" + numberOfDoors + ", clearance=" + clearance + ", trunk=" + trunk
		+ ", volumeOfTheTank=" + volumeOfTheTank + ", numberOfPlaces=" + numberOfPlaces + ", price=" + price
		+ ", image=" + image + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + base;
	result = prime * result + ((bodyType == null) ? 0 : bodyType.hashCode());
	result = prime * result + clearance;
	result = prime * result + height;
	result = prime * result + ((image == null) ? 0 : image.hashCode());
	result = prime * result + length;
	result = prime * result + ((modelID == null) ? 0 : modelID.hashCode());
	result = prime * result + numberOfDoors;
	result = prime * result + numberOfPlaces;
	result = prime * result + price;
	result = prime * result + trunk;
	result = prime * result + volumeOfTheTank;
	result = prime * result + width;
	result = prime * result + year;
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
	if (base != other.base)
	    return false;
	if (bodyType == null) {
	    if (other.bodyType != null)
		return false;
	} else if (!bodyType.equals(other.bodyType))
	    return false;
	if (clearance != other.clearance)
	    return false;
	if (height != other.height)
	    return false;
	if (image == null) {
	    if (other.image != null)
		return false;
	} else if (!image.equals(other.image))
	    return false;
	if (length != other.length)
	    return false;
	if (modelID == null) {
	    if (other.modelID != null)
		return false;
	} else if (!modelID.equals(other.modelID))
	    return false;
	if (numberOfDoors != other.numberOfDoors)
	    return false;
	if (numberOfPlaces != other.numberOfPlaces)
	    return false;
	if (price != other.price)
	    return false;
	if (trunk != other.trunk)
	    return false;
	if (volumeOfTheTank != other.volumeOfTheTank)
	    return false;
	if (width != other.width)
	    return false;
	if (year != other.year)
	    return false;
	return true;
    }

}
