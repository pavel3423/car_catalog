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
    @Column(name = "salt", unique = true, nullable = false)
    private String salt;
    private Role roleID;

    public User() {
    }

    public User(int id) {
	super(id);
    }

    public User(int id, String login, String email, String password, String salt, Role roleID) {
	super(id);
	this.login = login;
	this.email = email;
	this.password = password;
	this.salt = salt;
	this.roleID = roleID;
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

    public String getSalt() {
	return salt;
    }

    public void setSalt(String salt) {
	this.salt = salt;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "roleID")
    public Role getRoleID() {
	return roleID;
    }

    public void setRoleID(Role roleID) {
	this.roleID = roleID;
    }

    @Override
    public String toString() {
	return "User [getId()=" + getId() + ", login=" + login + ", email=" + email + ", password=" + password
		+ ", salt=" + salt + ", roleID=" + roleID + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((login == null) ? 0 : login.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((roleID == null) ? 0 : roleID.hashCode());
	result = prime * result + ((salt == null) ? 0 : salt.hashCode());
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
	if (roleID == null) {
	    if (other.roleID != null)
		return false;
	} else if (!roleID.equals(other.roleID))
	    return false;
	if (salt == null) {
	    if (other.salt != null)
		return false;
	} else if (!salt.equals(other.salt))
	    return false;
	return true;
    }

}