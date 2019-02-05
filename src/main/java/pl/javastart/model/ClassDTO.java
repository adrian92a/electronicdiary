package pl.javastart.model;

public class ClassDTO {
	public Integer classId;
	public Integer classNumber;
	public String classLetter;

	
	
	
	public ClassDTO() {
		super();
	}
	public ClassDTO(Integer classId, Integer classNumber, String classLetter) {
		super();
		this.classId = classId;
		this.classNumber = classNumber;
		this.classLetter = classLetter;
	}
	
	
	
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}
	public String getClassLetter() {
		return classLetter;
	}
	public void setClassLetter(String classLetter) {
		this.classLetter = classLetter;
	}

	

}
