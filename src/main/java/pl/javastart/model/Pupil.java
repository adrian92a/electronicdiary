package pl.javastart.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Pupil implements Serializable {
    private static final long serialVersionUID = 8539936152170847419L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
	public String  keyRegisterValue;
	public String firstName;
	public String lastName;
	public String pesel;
	public String className;
	public String login;
	public String password;
   // public Set<Mark> marks;
    
	@OneToOne
    @JoinColumn(name = "user_id")
    private User user;

	public Pupil() {
		super();
	}

	public Pupil(String keyRegisterValue, String firstName, String lastName, String pesel,
			String className, String login, String password, User user) {
		super();
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.className = className;
		this.login = login;
		this.password = password;
		this.user = user;
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


	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	




}