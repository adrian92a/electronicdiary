package pl.javastart.model;

public class PupilDTO implements Comparable<PupilDTO> {
	public Integer index;
	public Integer pupilId;
	public String firstName;
	public String lastName;
	public Integer lessonId;
	public Integer getIndex() {
		return index;
	}

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public PupilDTO(Integer index, Integer pupilId, String firstName, String lastName, Integer lessonId) {
		super();
		this.index = index;
		this.pupilId = pupilId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lessonId = lessonId;
	}

	public PupilDTO(Integer index, Integer pupilId, String firstName, String lastName) {
		super();
		this.index = index;
		this.pupilId = pupilId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setIndex(Integer index) {
		this.index = index;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

 
	@Override
	 public int compareTo(PupilDTO o) {
	        int a = index.compareTo(o.getIndex());
	       if (a==0){
	          a = index.compareTo(o.getIndex());
	       }
	       return a;
	}
}
