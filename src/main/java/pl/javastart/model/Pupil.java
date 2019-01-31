package pl.javastart.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="pupil")
public class Pupil implements Serializable {
    private static final long serialVersionUID = 8539936152170847419L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pupil_id")
    public int id;
	public String firstName;
	public String lastName;
	public String pesel;
	
	@OneToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	 @ManyToOne
	 @JoinColumn(name="schollclass_id")
	 private Schollclass schollclass;
	 
	 @OneToMany
	 @JoinTable(name="pupil_mark",
	 	joinColumns = @JoinColumn(name="pupil_id"),
	 	inverseJoinColumns=@JoinColumn(name="mark_id"))
	 private Set<Mark> marks;
   // public Set<Mark> marks;
    


	public Schollclass getSchollclass() {
		return schollclass;
	}

	public Pupil(String firstName, String lastName, String pesel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
	}

	public Pupil(String firstName, String lastName, String pesel, User user, Schollclass schollclass, Set<Mark> marks) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.user = user;
		this.schollclass = schollclass;
		this.marks = marks;
	}

	public void setSchollclass(Schollclass schollclass) {
		this.schollclass = schollclass;
	}

	public Pupil() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Pupil( String firstName, String lastName, String pesel, Schollclass schollclass,
			User user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.schollclass = schollclass;
		this.user = user;
	}
}
	
	

	




