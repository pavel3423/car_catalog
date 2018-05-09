package by.htp.car_catalog.domain;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "models_car")
public class ModelCar extends Entity {

    private static final long serialVersionUID = 6379681683695619732L;

    private BrandCar brandCar;
    @Column(name = "model")
    private String model;

    public ModelCar() {
    }

    public ModelCar(int id) {
	super(id);
    }

    public ModelCar(int id, BrandCar brandCar, String model) {
	super(id);
	this.brandCar = brandCar;
	this.model = model;
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

    @Override
    public String toString() {
	return "ModelCar [getId()=" + getId() + ", brandCar=" + brandCar + ", model=" + model + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((brandCar == null) ? 0 : brandCar.hashCode());
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
	if (model == null) {
	    if (other.model != null)
		return false;
	} else if (!model.equals(other.model))
	    return false;
	return true;
    }

}
