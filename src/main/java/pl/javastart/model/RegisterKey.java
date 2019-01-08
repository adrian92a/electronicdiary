package pl.javastart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
public class RegisterKey implements Serializable {
	  private static final long serialVersionUID =8539936152170847419L;
	  
	@Id
	@GeneratedValue  
	private Long id;
	public String  keyRegisterValue;
	public String firstName;
	public String lastName;
	public String pesel;
	public Role role;
	

	public RegisterKey(String keyRegisterValue, String firstName, String lastName, String pesel, Role role) {
		super();
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.role = role;
	}

	public RegisterKey(String keyRegisterValue) 
	{
		this.keyRegisterValue = keyRegisterValue;
	}

	public RegisterKey() 
	{	
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getKeyRegisterValue() 
	{
		return keyRegisterValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setKeyRegisterValue(String keyRegisterValue) {
		this.keyRegisterValue = keyRegisterValue;
	}
	
	

}
