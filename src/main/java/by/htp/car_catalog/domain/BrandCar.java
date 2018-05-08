package by.htp.car_catalog.domain;

import java.util.List;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "brands_car")
public class BrandCar extends Entity {

    private static final long serialVersionUID = -6226794434941096791L;
    @Column(name = "brand")
    private String brand;

    public BrandCar() {
    }

    public BrandCar(int id) {
	super(id);
    }

    public BrandCar(int id, String brand, List<ModelCar> models, List<Car> cars) {
	super(id);
	this.brand = brand;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Override
    public int getId() {
	// TODO Auto-generated method stub
	return super.getId();
    }

    @Override
    public void setId(int id) {
	// TODO Auto-generated method stub
	super.setId(id);
    }

    public String getBrand() {
	return brand;
    }

    public void setBrand(String brand) {
	this.brand = brand;
    }

    @Override
    public String toString() {
	return "BrandCar [getId()=" + getId() + ", brand=" + brand + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((brand == null) ? 0 : brand.hashCode());
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
	return true;
    }

}
