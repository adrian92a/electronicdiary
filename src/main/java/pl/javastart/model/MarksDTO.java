package pl.javastart.model;

import java.util.Set;

public class MarksDTO {
	public int  markValue;
	public String subjectName;
	public int getMarkValue() {
		return markValue;
	}
	public void setMarkValue(int markValue) {
		this.markValue = markValue;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public MarksDTO(int markValue, String subjectName) {
		super();
		this.markValue = markValue;
		this.subjectName = subjectName;
	}
	
	

}
