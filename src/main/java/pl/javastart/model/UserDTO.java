package pl.javastart.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {
    @NotEmpty(message = "Wpisz swój E-mail")
    @Email(message = "Podałeś nieprawidłowy email")
    private String email;

    @Size(min = 7, max = 20, message = "Hasło jest nieprawdłowe. Należy podać od 7 do 20, znaków")
    private String password;
    private Role role;
    private String registerKey;
    public UserDTO() {
    }

    public UserDTO(String email, String password, Role role, String registerKey) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.registerKey = registerKey;
    }

    public String getRegisterKey() {
        return registerKey;
    }

    public void setRegisterKey(String registerKey) {
        this.registerKey = registerKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserDTO(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
