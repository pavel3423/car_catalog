package by.htp.car_catalog.domain;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "models_car")
public class ModelCar extends Entity {

    private static final long serialVersionUID = 6379681683695619732L;

    private BrandCar brandID;
    @Column(name = "model")
    private String model;
    @Column(name = "image")
    private String image;

    public ModelCar() {
    }

    public ModelCar(int id) {
	super(id);
    }

    public ModelCar(int id, BrandCar brandID, String model, String image) {
	super(id);
	this.brandID = brandID;
	this.model = model;
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

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "brandID")
    public BrandCar getBrandID() {
	return brandID;
    }

    public void setBrandID(BrandCar brandID) {
	this.brandID = brandID;
    }

    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    @Override
    public String toString() {
	return "ModelCar [getId()=" + getId() + ", brandID=" + brandID + ", model=" + model + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((brandID == null) ? 0 : brandID.hashCode());
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
	if (brandID == null) {
	    if (other.brandID != null)
		return false;
	} else if (!brandID.equals(other.brandID))
	    return false;
	if (model == null) {
	    if (other.model != null)
		return false;
	} else if (!model.equals(other.model))
	    return false;
	return true;
    }

}
