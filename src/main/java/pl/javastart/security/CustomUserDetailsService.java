package pl.javastart.security;

import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.javastart.model.Role;
import pl.javastart.model.User;
import pl.javastart.repository.UserRepository;


@Configuration
public class CustomUserDetailsService implements UserDetailsService {
	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByLogin(username);
		if(user == null)
			throw new UsernameNotFoundException("User not found");
		org.springframework.security.core.userdetails.User userDetails = 
				new org.springframework.security.core.userdetails.User(
						user.getLogin(), 
						user.getPassword(), 
						convertAuthorities(user.getRoles()));
		return userDetails;
	}

	private Set<GrantedAuthority> convertAuthorities(Set<Role> userRoles) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		for(Role ur: userRoles) {
			authorities.add(new SimpleGrantedAuthority(ur.getRoleName()));
		}
		return authorities;
	}


}