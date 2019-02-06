package pl.javastart.model;

import java.util.Set;

public class MarksDTO {
	public Integer  markValue;
	public String subjectName;
	public String markPurpose;
	public Integer markWeight;
	public Integer lessonId;
	public Integer pupilId;
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
	public String getMarkPurpose() {
		return markPurpose;
	}
	public void setMarkPurpose(String markPurpose) {
		this.markPurpose = markPurpose;
	}
	public Integer getMarkWeight() {
		return markWeight;
	}
	public void setMarkWeight(Integer markWeight) {
		this.markWeight = markWeight;
	}
	public MarksDTO(int markValue,  String markPurpose, Integer markWeight) {
		super();
		this.markValue = markValue;
		this.markPurpose = markPurpose;
		this.markWeight = markWeight;
	}
	public MarksDTO(Integer markValue, String markPurpose, Integer markWeight, Integer lessonId, Integer pupilId) {
		super();
		this.markValue = markValue;
		this.markPurpose = markPurpose;
		this.markWeight = markWeight;
		this.lessonId = lessonId;
		this.pupilId = pupilId;
	}
	public Integer getLessonId() {
		return lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	public Integer getPupilId() {
		return pupilId;
	}
	public void setPupilId(Integer pupilId) {
		this.pupilId = pupilId;
	}
	public void setMarkValue(Integer markValue) {
		this.markValue = markValue;
	}

	

}
