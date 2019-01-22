package pl.javastart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pl.javastart.model.User;
import pl.javastart.model.Role;
import pl.javastart.repository.UserRepository;
import pl.javastart.repository.RoleRepository;;

@Service
public class UserService {

	private static final String DEFAULT_ROLE = "ROLE_USER";
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public void addUser(User user) {
		String passwordHash = passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordHash);
		userRepository.save(user);
	}

	
}