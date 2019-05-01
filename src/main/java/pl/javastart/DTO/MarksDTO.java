package pl.javastart.DTO;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

public class MarksDTO {
	@Size(min = 1, max = 6, message = "niepoprawna wartość")
	public Integer  markValue;
	public String subjectName;
	public String markPurpose;
	@Size(min = 1, max = 10, message = "niepoprawna wartość")
	public Integer markWeight;
	public Integer lessonId;
	public Integer pupilId;
	public Integer index;
	public Integer markId;
	public LocalDate markDate;

	public MarksDTO(Integer markValue, String markPurpose, Integer markWeight, Integer markId) {
		this.markValue = markValue;
		this.markPurpose = markPurpose;
		this.markWeight = markWeight;
		this.markId = markId;
	}

	public LocalDate getMarkDate() {
		return markDate;
	}

	public Integer getMarkId() {
		return markId;
	}

	public void setMarkId(Integer markId) {
		this.markId = markId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public MarksDTO(Integer markId,Integer markValue, String markPurpose, Integer markWeight, LocalDate markDate, Integer index) {
		this.markValue = markValue;
		this.markPurpose = markPurpose;
		this.markWeight = markWeight;
		this.index = index;
		this.markDate=markDate;
		this.markId=markId;
	}

	public enum Purpose {

		SPRAWDZIAN("Sprawdzian"), 
		KARTKOWKA("Kartkówka"), 
		ODPOWIEDZUSTNA("Odpowiedz ustna"),
		PRACA_DOMOWA("Praca domowa"),
		INNE("inne");
		
		String name;

		private Purpose(String name) {
			this.name = name;
		}
	}

	public MarksDTO() {
	}

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
	public MarksDTO(int markValue, String markPurpose, Integer markWeight, LocalDate markDate) {
		super();
		this.markValue = markValue;
		this.markPurpose = markPurpose;
		this.markWeight = markWeight;
		this.markDate=markDate;
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
