package pl.javastart.controller.web;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;
import org.springframework.security.crypto.password.PasswordEncoder;

import pl.javastart.model.Lesson;
import pl.javastart.model.User;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.UserRepository;

@Controller
//@RequestMapping(value = "account")
public class AccountController {
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
UserRepository userRepository;

@Autowired
LessonRepository lessonRepo;


	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(
		@RequestParam("email") String email,
		@RequestParam("password") String password,
	
		HttpSession session,
		ModelMap modelMap) {
		
		System.out.println("---------AccountController");
	
		 System.out.println(	passwordEncoder.encode(password) +"---------AccountController");
		System.out.println(userRepository.findLoginAndPassword(email,passwordEncoder.encode(password))+"---------AccountController");
//		if(email.equalsIgnoreCase("q") && password.equalsIgnoreCase("q"))
		if(userRepository.findLoginAndPassword(email,password)>0)
		{	
			session.setAttribute("email", email);
				userRepository.findUserRole(email);
				String rolename = userRepository.findUserRole(email);
				session.setAttribute("rolename", rolename);	
			System.out.println("------------ "+rolename);
			
			 List<Lesson> subjectNames =  lessonRepo.findDistinctSubject();
			 modelMap.put("subjectNames",subjectNames);
			
			
			return "index";
		} else {
			modelMap.put("error", "Invalid Account");
			return "index";
		}
	}
	
	
	  public String userName(HttpSession session)
	  {
		String email=(String) session.getAttribute("email");
		return email;
	  }
	 
	  

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("email");
		session.removeAttribute("email");
		return "index";
	}
 

}