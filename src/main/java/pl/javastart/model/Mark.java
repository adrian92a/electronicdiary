package pl.javastart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mark")
public class Mark implements Serializable {
private static final long serialVersionUID = 7021150458271420830L;
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="mark_id")
	 private Integer id;
	 
	 public Integer markValue;
	 public Integer markWeight;
	 public String markPurpose;
	 @ManyToOne
	    @JoinColumn(name="lesson_id")
	    private Lesson lesson;
		
		public Integer getId() {
		return id;
	}
	public Lesson getLesson() {
			return lesson;
		}



		public Mark(Integer markValue, Integer markWeight, String markPurpose) {
		super();
		this.markValue = markValue;
		this.markWeight = markWeight;
		this.markPurpose = markPurpose;
	}
		public Mark(Integer markValue, Integer markWeight, String markPurpose, Pupil pupil) {
		super();
		this.markValue = markValue;
		this.markWeight = markWeight;
		this.markPurpose = markPurpose;
		this.pupil = pupil;
	}
		public Mark(Integer markValue, Integer markWeight, String markPurpose, Lesson lesson, Pupil pupil) {
		super();
		this.markValue = markValue;
		this.markWeight = markWeight;
		this.markPurpose = markPurpose;
		this.lesson = lesson;
		this.pupil = pupil;
	}
		public void setLesson(Lesson lesson) {
			this.lesson = lesson;
		}



	public Integer getMarkWeight() {
			return markWeight;
		}
		public void setMarkWeight(Integer markWeight) {
			this.markWeight = markWeight;
		}
		public String getMarkPurpose() {
			return markPurpose;
		}
		public void setMarkPurpose(String markPurpose) {
			this.markPurpose = markPurpose;
		}
	public Mark(Integer id, Integer markValue, Pupil pupil) {
			super();
			this.id = id;
			this.markValue = markValue;
			this.pupil = pupil;
		}







	public void setId(Integer id) {
		this.id = id;
	}



		public Mark() {
		super();
	}



		public Mark(Pupil pupil) {
			super();
			this.pupil = pupil;
		}



		public Mark(Integer markValue, Pupil pupil) {
			super();
			this.markValue = markValue;
			this.pupil = pupil;
		}



		public Integer getMarkValue() {
			return markValue;
		}



		public void setMarkValue(Integer markValue) {
			this.markValue = markValue;
		}



		public Pupil getPupil() {
			return pupil;
		}



		public void setPupil(Pupil pupil) {
			this.pupil = pupil;
		}



		public Mark(Integer markValue) {
		super();
		this.markValue = markValue;
	}



		@ManyToOne
	    @JoinColumn(name = "pupil_id")
	    private Pupil pupil;
	 
	 
	 
	 
	 

}

