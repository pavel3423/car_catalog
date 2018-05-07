package by.htp.car_catalog.domain;

import java.util.List;

public class Role extends Entity {

    private static final long serialVersionUID = -6226794434941096791L;

    private String role;
    private List<User> users;

    public Role() {
    }

    public Role(int id) {
	super(id);
    }

    public Role(int id, String role, List<User> users) {
	super(id);
	this.role = role;
	this.users = users;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    public List<User> getUsers() {
	return users;
    }

    public void setUsers(List<User> users) {
	this.users = users;
    }

    @Override
    public String toString() {
	return "Role [getId()=" + getId() + ", role=" + role + ", users=" + users + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result + ((users == null) ? 0 : users.hashCode());
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
	if (users == null) {
	    if (other.users != null)
		return false;
	} else if (!users.equals(other.users))
	    return false;
	return true;
    }

}
