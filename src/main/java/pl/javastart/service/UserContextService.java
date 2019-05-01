package pl.javastart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.javastart.model.User.User;
import pl.javastart.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserContextService {
    private UserRepository userRepository;

    @Autowired
    public UserContextService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<String> getRoles()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = authentication.getAuthorities().stream()
                .map(r -> r.getAuthority()).collect(Collectors.toSet());
        List<String> listOfRoles = new ArrayList<String>();
        listOfRoles.addAll(roles);
    return listOfRoles;
    }
    public boolean hasRole(String roleName){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication instanceof AnonymousAuthenticationToken){
            return false;
        }

        return authentication.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .anyMatch(s -> s.equals(roleName));

    }

    public String getLoggedAs() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        return authentication.getName();
    }

    public boolean isLogged() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {

            return false;
        }
        return authentication.isAuthenticated();
    }
}
