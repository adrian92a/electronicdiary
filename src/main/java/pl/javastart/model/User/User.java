package pl.javastart.model.User;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@XmlRootElement
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	@Column(name="email", length = 150, unique = true)
	private String email;
	@Column(name = "passwordHash")
	private String password;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles= new HashSet<>();

	public void addRole(Role role){
		if(roles == null){
			roles = new HashSet<>();
		}

		roles.add(role);
	}

	public User(String email, String password, Set<Role> roles) {
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

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
	public Set<Role> getRoles() {
		return this.roles;
	}


}