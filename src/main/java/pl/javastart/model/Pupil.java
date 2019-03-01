package pl.javastart.model;

import pl.javastart.model.User.User;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	 


	public Schollclass getSchollclass() {
		return schollclass;
	}

	public Pupil(String firstName, String lastName, String pesel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
	}

	public Pupil(String firstName, String lastName, String pesel, User user, Schollclass schollclass) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.user = user;
		this.schollclass = schollclass;
	
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
	
	

	




