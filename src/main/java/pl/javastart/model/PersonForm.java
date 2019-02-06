package pl.javastart.model;

public class PersonForm {
	 
    private String fullName;
 
    private Integer lessonId;
 
    public String getFullName() {
        return fullName;
    }
 
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
 
    public Integer getCountryId() {
        return lessonId;
    }
 
    public void setCountryId(Integer classId) {
        this.lessonId = classId;
    }
}