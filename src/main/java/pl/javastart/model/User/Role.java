package pl.javastart.model.User;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="role")
public class Role implements Serializable {
	private static final long serialVersionUID = 7021150458271420830L;
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="role_name")
	private String roleName;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


	public Role(String roleName, User user) {
		this.roleName = roleName;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role() {
		super();
	}


}

