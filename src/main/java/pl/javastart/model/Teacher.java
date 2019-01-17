package pl.javastart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Teacher implements Serializable {
    private static final long serialVersionUID = 8539936152170847419L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
	public String  keyRegisterValue;
	public String firstName;
	public String lastName;
	public String pesel;
	public String roleName;
	public String login;
	public String password;
	
	 
	@OneToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	
	public Teacher(String keyRegisterValue, String firstName, String lastName, String pesel, String roleName,
			String login, String password, User users) {
		super();
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.roleName = roleName;
		this.login = login;
		this.password = password;
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User users) {
		this.user = user;
	}
	public Teacher() {
		super();
	}
	public Teacher(String keyRegisterValue, String firstName, String lastName, String pesel, String roleName,
			String login, String password) {
		super();
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.roleName = roleName;
		this.login = login;
		this.password = password;
	}
	public String getKeyRegisterValue() {
		return keyRegisterValue;
	}
	public void setKeyRegisterValue(String keyRegisterValue) {
		this.keyRegisterValue = keyRegisterValue;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
