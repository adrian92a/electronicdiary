package pl.javastart.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


public class RegisterKeyAndRoleDTO {

	public String  keyRegisterValue;
	public String firstName;
	public String lastName;
	public String pesel;
	public Set<Role> roleName;
	public String className;
	private String login;
    private String password;
    public String keyError;
	
	public RegisterKeyAndRoleDTO(String keyRegisterValue, String firstName, String lastName, String pesel,
			 Set<Role> roleName, String className, String login, String password, String keyError) {
		super();
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.roleName = roleName;
		this.className = className;
		this.login = login;
		this.password = password;
		this.keyError = keyError;
	}
	public String getKeyError() {
		return keyError;
	}
	public void setKeyError(String keyError) {
		this.keyError = keyError;
	}
	public RegisterKeyAndRoleDTO(String keyRegisterValue, String firstName, String lastName, String pesel,
			 Set<Role> roleName, String className, String login, String password) {
		super();
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.roleName = roleName;
		this.className = className;
		this.login = login;
		this.password = password;
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
	public RegisterKeyAndRoleDTO(String keyRegisterValue, String firstName, String lastName, String pesel,
			 Set<Role> roleName, String className) {
		super();
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.roleName = roleName;
		this.className = className;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public RegisterKeyAndRoleDTO() {
		super();
	}
	public RegisterKeyAndRoleDTO(String keyRegisterValue, String firstName, String lastName, String pesel,
			 Set<Role> roleName) {
		super();
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.roleName = roleName;
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
	public Set<Role> getRoleName() {
		return roleName;
	}
	public void setRoleName(Set<Role> roleName) {
		this.roleName = roleName;
	}

}
