package pl.javastart.model;

import java.util.Set;



public class RegisterKeyAndRoleDTO {

	public String  keyRegisterValue;
	public String firstName;
	public String lastName;
	public String pesel;
	public Set<Role> roleName;
	public Integer schollClassnumber;
	public String schollClassLetter;
	private String login;
    private String password;
    public String keyError;
    
	public RegisterKeyAndRoleDTO() {
		super();
	}

	public RegisterKeyAndRoleDTO(String keyRegisterValue, String firstName, String lastName, String pesel,
			Set<Role> roleName, Integer schollClassnumber, String schollClassLetter, String login, String password) {
		super();
		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.roleName = roleName;
		this.schollClassnumber = schollClassnumber;
		this.schollClassLetter = schollClassLetter;
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

	public Set<Role> getRoleName() {
		return roleName;
	}

	public void setRoleName(Set<Role> roleName) {
		this.roleName = roleName;
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

	public String getKeyError() {
		return keyError;
	}

	public void setKeyError(String keyError) {
		this.keyError = keyError;
	}
	
	
	

}
