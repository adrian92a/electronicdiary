package pl.javastart.model;

import pl.javastart.model.User.User;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Teacher implements Serializable {
    private static final long serialVersionUID = 8539936152170847419L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="teacher_id")
    public int id;
	public String firstName;
	public String lastName;
	public String pesel;
	public Teacher() {super();}
	 
	@OneToOne
    @JoinColumn(name = "user_id")
    private User user;


	public Teacher(String firstName, String lastName, String pesel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
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





	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	

}
