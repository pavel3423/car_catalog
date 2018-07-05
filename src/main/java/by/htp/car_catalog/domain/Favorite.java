package by.htp.car_catalog.domain;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "favorites")
public class Favorite extends Entity {

    private static final long serialVersionUID = 4235851146511954994L;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "car")
    private Car car;

    public Favorite() {
    }

    public Favorite(int id) {
	super(id);
    }

    public Favorite(int id, User user, Car car) {
	super(id);
	this.user = user;
	this.car = car;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "userID", nullable = true)
    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "carID", nullable = true)
    public Car getCar() {
	return car;
    }

    public void setCar(Car car) {
	this.car = car;
    }

    @Override
    public String toString() {
	return "Favorite [user=" + user + ", car=" + car + ", getId()=" + getId() + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((car == null) ? 0 : car.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
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
	if (car == null) {
	    if (other.car != null)
		return false;
	} else if (!car.equals(other.car))
	    return false;
	if (user == null) {
	    if (other.user != null)
		return false;
	} else if (!user.equals(other.user))
	    return false;
	return true;
    }

}
