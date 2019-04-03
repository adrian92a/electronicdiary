package pl.javastart.service;

import lombok.Getter;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import pl.javastart.model.User.Role;
import pl.javastart.model.User.User;
import pl.javastart.repository.RoleRepository;
import pl.javastart.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Scope(value = "session")
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSessionService {

    private UserRepository userRepository;

    private RoleRepository roleRepo;



    private PasswordEncoder passwordEncoder;

    @Getter
    private boolean logged;

    @Getter
    private User user;

    public UserSessionService(UserRepository userRepository, RoleRepository roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean loginUser(String email, String password, HttpSession session)
    {

        Optional<User> userOptional = userRepository.findByEmail(email);
        if(!userOptional.isPresent())
        {
            this.logged=false;
            return false;
        }
        System.out.println("----------2"+password);
        if(passwordEncoder.
                matches(password,
                        userOptional.
                                get().
                                getPassword())){
            this.logged = true;
            this.user = userOptional.get();

            session.setAttribute("email", email);
            List<Role> roles=  roleRepo.findRoleByUsers(userRepository.findByEmail(email).get());
            List<String> rolesName=new ArrayList<>();
                    for(Role r:roles)
                    {
                        rolesName.add(r.getRoleName());
                    }

            session.setAttribute(
                    "rolename",
         //           userRepository.findUserRole(email));
                    rolesName);
                return true;

        }
        this.logged = false;
        return false;
    }
    public void logout(HttpSession session){
        this.logged = false;
        this.user = null;
        session.removeAttribute("email");
        session.removeAttribute("rolename");
    }


}
