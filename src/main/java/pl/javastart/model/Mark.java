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
	 private Long id;
	 
	 public Integer markValue;
	
	 @ManyToOne
	    @JoinColumn(name="lesson_id")
	    private Lesson lesson;
		
		public Long getId() {
		return id;
	}



	public Lesson getLesson() {
			return lesson;
		}



		public void setLesson(Lesson lesson) {
			this.lesson = lesson;
		}



	public Mark(Long id, Integer markValue, Pupil pupil) {
			super();
			this.id = id;
			this.markValue = markValue;
			this.pupil = pupil;
		}







	public void setId(Long id) {
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

