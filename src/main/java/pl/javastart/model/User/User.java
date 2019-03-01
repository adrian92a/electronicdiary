package pl.javastart.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity(name="User")
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 8539936152170847419L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	private String email;
	private String password;



	public User()
	{}
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;}
	public String getEmail() {
		return email;}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return email;
	}
	public void setLogin(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUsername() {
		return email;
	}

	public void setUsername(String email) {
		this.email = email;
	}




}