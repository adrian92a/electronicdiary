package pl.javastart.model;

public class PupilDTO {
	public Integer pupilId;
	public String firstName;
	public String lasName;

	
	
	public PupilDTO(Integer pupilId, String firstName, String lasName) {
		super();
		this.pupilId = pupilId;
		this.firstName = firstName;
		this.lasName = lasName;
	}
	public Integer getPupilId() {
		return pupilId;
	}
	public void setPupilId(Integer pupilId) {
		this.pupilId = pupilId;
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
