package by.htp.car_catalog.domain;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "roles")
public class Role extends Entity {

    private static final long serialVersionUID = -6226794434941096791L;
    @Column(name = "role")
    private String role;

    public Role() {
    }

    public Role(int id) {
	super(id);
    }

    public Role(int id, String role) {
	super(id);
	this.role = role;

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

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    @Override
    public String toString() {
	return "Role [getId()=" + getId() + ", role=" + role + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((role == null) ? 0 : role.hashCode());
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
	Role other = (Role) obj;
	if (role == null) {
	    if (other.role != null)
		return false;
	} else if (!role.equals(other.role))
	    return false;
	return true;
    }

}
