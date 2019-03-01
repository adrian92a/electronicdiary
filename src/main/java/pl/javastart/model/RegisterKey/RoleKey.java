package pl.javastart.model.RegisterKey;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement
@Entity
@Table(name="rolekey")
public class RoleKey implements Serializable {
    private static final long serialVersionUID = 7021150458271420830L;
    @Id
    @Column(name="roleKey_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="role_key_name")
    private String keyRoleName;

    @ManyToOne
    @JoinColumn(name="register_key_id")
    private RegisterKey registerKey;

    public RoleKey(String keyRoleName, RegisterKey registerKey) {
        this.keyRoleName = keyRoleName;
        this.registerKey = registerKey;
    }

    public RoleKey() {
        super();
    }

    public RoleKey(String roleName) {
        super();
        this.keyRoleName = roleName;
    }

    public String getRoleName() {
        return keyRoleName; }

    public void setRoleName(String roleName) {
        this.keyRoleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RoleKey{" +
                "id=" + id +
                ", roleName='" + keyRoleName + '\'' +
                '}';
    }
}
