package pl.javastart.model;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = 7021150458271420830L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="role_id")
private int id;
private String roleName;
public Role() {
}
public Role(String roleName) {
	this.roleName = roleName;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "Role [id=" + id + ", roleName=" + roleName + "]";}
}

