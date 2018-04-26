package by.htp.car_catalog.domain;

public class Favorite extends Entity {

	private static final long serialVersionUID = 4235851146511954994L;

	private int userID;
	private int carID;

	public Favorite() {
	}

	public Favorite(int id, int userID, int carID) {
		super(id);
		this.userID = userID;
		this.carID = carID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	@Override
	public String toString() {
		return "Favorite [userID=" + userID + ", carID=" + carID + ", getId()=" + getId() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + carID;
		result = prime * result + userID;
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
		Favorite other = (Favorite) obj;
		if (carID != other.carID)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

}
