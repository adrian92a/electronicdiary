package pl.javastart.controller.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.model.Lesson;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.UserRepository;

@Controller
public class AccountController {

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
		ModelMap modelMap,
		Model model)
	{
		if(userRepository.checkIfUsersEmailAndPasswordExists(email,password))
		{	
				session.setAttribute("email", email);
				session.setAttribute("rolename",userRepository.findUserRole(email));
				List<Lesson> subjectNames =  lessonRepo.findDistinctSubject();
				modelMap.put("subjectNames",subjectNames);
				modelMap.put("subjectNames",subjectNames);
				String successfulLoginMessage="Zostałeś pomyślnie zalogowany";
				model.addAttribute("message",successfulLoginMessage);
				return "index";
		}
		else
		{
				redirectAttributes.addFlashAttribute("message", "Niepoprawny email lub hasło");
				return "redirect:loginform/";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("email");
		session.removeAttribute("rolename");
		String successfulLogoutMessage="Zostałeś pomyślnie wylogowany";
		model.addAttribute("message",successfulLogoutMessage);
		return "index";
	}
 

}