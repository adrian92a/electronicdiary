package pl.javastart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import pl.javastart.model.Role;
import pl.javastart.model.User;
import pl.javastart.repository.RegisterKeyRepository;
import pl.javastart.repository.UserRepository;

@SpringBootApplication
public class SpringMvcRestDataApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcRestDataApplication.class, args);


	}

}

