package pl.javastart.DTO;

public class TeacherDTO {
	public String firstName;
	public String lasName;
	public TeacherDTO(String firstName, String lasName) {
		super();
		this.firstName = firstName;
		this.lasName = lasName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasName() {
		return lasName;
	}
	public void setLasName(String lasName) {
		this.lasName = lasName;
	}
	
	
}
