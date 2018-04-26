package by.htp.car_catalog.domain;

public class Car extends Entity {

	private static final long serialVersionUID = 1984566728743718380L;

	private int brandID;
	private int modelID;
	private String carClass;
	private int minPrice;
	private int maxPrice;

	public Car() {
	}

	public Car(int id) {
		super(id);
	}

	public Car(int id, int brandID, int modelID, String carClass, int minPrice, int maxPrice) {
		super(id);
		this.brandID = brandID;
		this.modelID = modelID;
		this.carClass = carClass;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}

	public int getModelID() {
		return modelID;
	}

	public void setModelID(int modelID) {
		this.modelID = modelID;
	}

	public String getCarClass() {
		return carClass;
	}

	public void setCarClass(String carClass) {
		this.carClass = carClass;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	@Override
	public String toString() {
		return "Car [brandID=" + brandID + ", modelID=" + modelID + ", carClass=" + carClass + ", minPrice=" + minPrice
				+ ", maxPrice=" + maxPrice + ", getId()=" + getId() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + brandID;
		result = prime * result + ((carClass == null) ? 0 : carClass.hashCode());
		result = prime * result + maxPrice;
		result = prime * result + minPrice;
		result = prime * result + modelID;
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
		if (brandID != other.brandID)
			return false;
		if (carClass == null) {
			if (other.carClass != null)
				return false;
		} else if (!carClass.equals(other.carClass))
			return false;
		if (maxPrice != other.maxPrice)
			return false;
		if (minPrice != other.minPrice)
			return false;
		if (modelID != other.modelID)
			return false;
		return true;
	}

}
