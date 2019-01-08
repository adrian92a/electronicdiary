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

	public RegisterKey(String keyRegisterValue) 
	{
		this.keyRegisterValue = keyRegisterValue;
	}

	public RegisterKey() 
	{	
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
