package pl.javastart.model;




import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable {
    private static final long serialVersionUID = 7021150458271420830L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="role_id")
private Long id;
private String roleName;



public Role() {
	super();
}

public Role(String roleName) {
	super();
	this.roleName = roleName;
}

public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Override
public String toString() {
	return "Role [id=" + id + ", roleName=" + roleName + "]";}
}

