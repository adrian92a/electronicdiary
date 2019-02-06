package pl.javastart.model;

import java.io.Serializable;
import java.util.Set;

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
@Table(name="lesson")
public class Lesson implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	
	
	
	

	public Lesson(Schollclass schollclass, Teacher teacher , String subjectName) {
		super();
		this.schollclass = schollclass;
		this.teacher = teacher;
		
		this.subjectName = subjectName;
	}


	public Lesson() {
		super();
	}


	public Lesson(String subjectName) {
		super();
		this.subjectName = subjectName;
	}


	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="lesson_id")
    private Integer id;
    
    @OneToOne
    @JoinColumn(name="schollclass_id")
    private Schollclass schollclass;   
	private String subjectName;
    @OneToOne	
    @JoinColumn(name="teacher_id")
    private Teacher teacher;
    

    
//    @OneToMany
//	@JoinTable(name="lesson_mark",
//	 	joinColumns = @JoinColumn(name="lesson_id"),
//	 	inverseJoinColumns=@JoinColumn(name="mark_id"))
//	 private Set<Mark> marks;
    
    
    public Schollclass getSchollclass() {
		return schollclass;
	}
	public void setSchollclass(Schollclass schollclass) {
		this.schollclass = schollclass;
	}
	public Teacher getTeacher() {
		return teacher;}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;}

	public String getSubjectName() {
		return subjectName;}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;}

   
}
