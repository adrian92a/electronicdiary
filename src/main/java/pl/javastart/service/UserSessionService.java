package pl.javastart.service;

import lombok.Getter;

import org.apache.catalina.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import pl.javastart.model.User.User;
import pl.javastart.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
//@Scope(value = "session")
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSessionService {

    private UserRepository userRepository;

    Session session;
    @Getter
    private boolean logged;

    @Getter
    private User user;

    public UserSessionService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean loginUser(String email, String password, HttpSession session)
    {

        Optional<User> userOptional = userRepository.findByEmail(email);
        if(!userOptional.isPresent())
        {
            this.logged=false;
            return false;
        }
        if(userOptional.get().getPassword().equals(password)){
            this.logged = true;
            this.user = userOptional.get();

            session.setAttribute("email", email);
            session.setAttribute(
                    "rolename",
                    userRepository.findUserRole(email));
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
