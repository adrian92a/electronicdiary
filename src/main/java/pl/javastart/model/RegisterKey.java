package pl.javastart.model;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class RegisterKey implements Serializable {
	  private static final long serialVersionUID =8539936152170847419L;
	  
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public String  keyRegisterValue;
	public String firstName;
	public String lastName;
	public String pesel;
	public Integer schollClassnumber;
	public String schollClassLetter;
	public Boolean used;


	public RegisterKey(String keyRegisterValue, String firstName, String lastName, String pesel,
			Integer schollClassnumber, String schollClassLetter, Boolean used, Role role) {
		super();
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.schollClassnumber = schollClassnumber;
		this.schollClassLetter = schollClassLetter;
		this.used = used;
		this.role = role;
	}

	public Integer getSchollClassnumber() {
		return schollClassnumber;
	}

	public void setSchollClassnumber(Integer schollClassnumber) {
		this.schollClassnumber = schollClassnumber;
	}

	public String getSchollClassLetter() {
		return schollClassLetter;
	}

	public void setSchollClassLetter(String schollClassLetter) {
		this.schollClassLetter = schollClassLetter;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "role_id")
    private Role role;
	

	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RegisterKey(String keyRegisterValue, String firstName, String lastName, String pesel) {
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;	
	}
	
	public RegisterKey(String keyRegisterValue, String firstName, String lastName, String pesel, Role role) {
		super();
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.role = role;
	}


	
	public RegisterKey() {
		super();
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



	public String getKeyRegisterValue() 
	{
		return keyRegisterValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setKeyRegisterValue(String keyRegisterValue) {
		this.keyRegisterValue = keyRegisterValue;
	}
	
	

}
