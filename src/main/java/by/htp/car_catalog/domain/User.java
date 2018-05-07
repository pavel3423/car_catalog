package by.htp.car_catalog.domain;

import java.util.List;

public class User extends Entity {

    private static final long serialVersionUID = -1919018243680435461L;

    private String login;
    private String email;
    private String password;
    private Role role;
    private List<Favorite> favorites;

    public User() {
    }

    public User(int id) {
	super(id);
    }

    public User(int id, String login, String email, String password, Role role, List<Favorite> favorites) {
	super(id);
	this.login = login;
	this.email = email;
	this.password = password;
	this.role = role;
	this.favorites = favorites;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    public List<Favorite> getFavorites() {
	return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
	this.favorites = favorites;
    }

    @Override
    public String toString() {
	return "User [getId()=" + getId() + ", login=" + login + ", email=" + email + ", password=" + password
		+ ", role=" + role + ", favorites=" + favorites + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((favorites == null) ? 0 : favorites.hashCode());
	result = prime * result + ((login == null) ? 0 : login.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
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
	User other = (User) obj;
	if (email == null) {
	    if (other.email != null)
		return false;
	} else if (!email.equals(other.email))
	    return false;
	if (favorites == null) {
	    if (other.favorites != null)
		return false;
	} else if (!favorites.equals(other.favorites))
	    return false;
	if (login == null) {
	    if (other.login != null)
		return false;
	} else if (!login.equals(other.login))
	    return false;
	if (password == null) {
	    if (other.password != null)
		return false;
	} else if (!password.equals(other.password))
	    return false;
	if (role == null) {
	    if (other.role != null)
		return false;
	} else if (!role.equals(other.role))
	    return false;
	return true;
    }

}
