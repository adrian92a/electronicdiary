package pl.javastart.model;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.List;

@Entity
@Table(name="schollclass")
public class Schollclass {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="schollclass_id")
	 public int id;
	 
	
	 @OneToMany(mappedBy="schollclass")
	    private List<Pupil> pupils = new ArrayList<>();
	 
	 public Integer classNumber;
	 public String classLetter;
	 
	public Schollclass() {
		super();
	}

	public Schollclass(int id, Integer classNumber, String classLetter) {
		super();
		this.id = id;
		this.classNumber = classNumber;
		this.classLetter = classLetter;
	}

	public Schollclass(Integer classNumber, String classLetter) {
		super();
		this.classNumber = classNumber;
		this.classLetter = classLetter;
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
