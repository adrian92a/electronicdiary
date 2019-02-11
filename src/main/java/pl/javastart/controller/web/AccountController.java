package pl.javastart.controller.web;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.SessionScope;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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


	@PostMapping(value = "login")
	public String login(
		@RequestParam("email") String email,
		@RequestParam("password") String password,
		RedirectAttributes redirectAttributes,
		HttpSession session,
		ModelMap modelMap, Model model) {
		if(userRepository.findByEmailPasswordExists(email,password))
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
			redirectAttributes.addFlashAttribute("message", "Niepoprany email lub hasło");

			return "redirect:loginform/";
		}
	}
	
	HttpSession session;
	  public String getUserEmail()
	  {
		String email=(String) session.getAttribute("email");
		return email;
	  }
	 
	  

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("email");
		session.removeAttribute("rolename");
		return "index";
	}
 

}