package pl.javastart.model;

public class RegisterKeyAndRoleDTO {

	public String  keyRegisterValue;
	public String firstName;
	public String lastName;
	public String pesel;
	public String roleName;
	
	
	
	
	
	public RegisterKeyAndRoleDTO() {
		super();
	}
	public RegisterKeyAndRoleDTO(String keyRegisterValue, String firstName, String lastName, String pesel,
			String roleName) {
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
