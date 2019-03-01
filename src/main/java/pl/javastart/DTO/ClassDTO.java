package pl.javastart.DTO;

public class ClassDTO {
	public Integer classId;
	public Integer classNumber;
	public String classLetter;
	public String subjectName;
	public Integer lessonId;
	public ClassDTO(Integer classId, Integer classNumber, String classLetter, String subjectName, Integer lessonId) {
		super();
		this.classId = classId;
		this.classNumber = classNumber;
		this.classLetter = classLetter;
		this.subjectName = subjectName;
		this.lessonId = lessonId;
	}
	
	
	
	public ClassDTO() {
		super();
	
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
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Integer getLessonId() {
		return lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	
	
		

	

}
