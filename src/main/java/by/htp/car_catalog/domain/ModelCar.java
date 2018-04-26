package by.htp.car_catalog.domain;

public class ModelCar extends Entity {

	private static final long serialVersionUID = 6379681683695619732L;

	private int brandID;
	private String model;

	public ModelCar() {
	}

	public ModelCar(int id, int brandID, String model) {
		super(id);
		this.brandID = brandID;
		this.model = model;
	}

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "ModelCar [brandID=" + brandID + ", model=" + model + ", getId()=" + getId() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + brandID;
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
		if (brandID != other.brandID)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

}
