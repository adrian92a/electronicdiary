package pl.javastart.DTO;


import pl.javastart.model.User.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;



public class RegisterKeyAndRoleDTO {

	public String  keyRegisterValue;
	public String firstName;
	public String lastName;
	public String pesel;
	public Integer roleId;
	public Set<Role> roleName;
	public Integer schollClassnumber;
	public String schollClassLetter;
	@NotEmpty
	@Email(message = "Podałeś nieprawidłowy email.")
	private String email;
	@NotEmpty
	@Size(min = 7, max = 20, message = "Hasło jest nieprawdłowe. Należy podać od 7 do 20, znaków")
    private String password;


	public RegisterKeyAndRoleDTO() {
		super();
	}

	public RegisterKeyAndRoleDTO(String keyRegisterValue, String firstName, String lastName, String pesel,
                                 Set<Role> roleName, Integer schollClassnumber,
                                 String schollClassLetter, String email,
                                 String password, Integer roleId) {

		this.keyRegisterValue = keyRegisterValue;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.roleName = roleName;
		this.schollClassnumber = schollClassnumber;
		this.schollClassLetter = schollClassLetter;
		this.email = email;
		this.password = password;
		this.roleId=roleId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

}
