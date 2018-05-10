package by.htp.car_catalog.domain;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "users")

public class User extends Entity {

    private static final long serialVersionUID = -1919018243680435461L;
    @Column(name = "login", unique = true, nullable = false)
    private String login;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", unique = true, nullable = false)
    private String password;
    private Role role;

    public User() {
    }

    public User(int id) {
	super(id);
    }

    public User(int id, String login, String email, String password, Role role) {
	super(id);
	this.login = login;
	this.email = email;
	this.password = password;
	this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    @Override
    public int getId() {
	return super.getId();
    }

    @Override
    public void setId(int id) {
	super.setId(id);
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

    @ManyToOne
    @JoinColumn(name = "roleID")
    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    @Override
    public String toString() {
	return "User [getId()=" + getId() + ", login=" + login + ", email=" + email + ", password=" + password
		+ ", role=" + role + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((email == null) ? 0 : email.hashCode());
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
