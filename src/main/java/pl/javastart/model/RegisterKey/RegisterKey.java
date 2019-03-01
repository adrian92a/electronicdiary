package pl.javastart.model.RegisterKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name="RegisterKey")
@Table(name="registerKey")
public class RegisterKey implements Serializable {
	private static final long serialVersionUID =8539936152170847419L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="register_key_id")
	private int id;
	@Column(name="key_register_value")
	public String  keyRegisterValue;
	public String firstName;
	public String lastName;
	public String pesel;
	public Integer schollClassnumber;
	public String schollClassLetter;


	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	public boolean used;



	public RegisterKey(String keyRegisterValue, String firstName, String lastName, String pesel, Integer schollClassnumber, String schollClassLetter, boolean used) {
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.schollClassnumber = schollClassnumber;
		this.schollClassLetter = schollClassLetter;
		this.used = used;
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



	public RegisterKey(String keyRegisterValue, String firstName, String lastName, String pesel) {
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
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
