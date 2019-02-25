package pl.javastart.controller.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.model.User;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.UserRepository;
import pl.javastart.serive.UserSessionService;

@Controller
public class UserController {

	private UserSessionService userSessionService;
	private UserRepository userRepository;
	private LessonRepository lessonRepo;

	public UserController(UserSessionService userSessionService, UserRepository userRepository, LessonRepository lessonRepo) {
		this.userSessionService = userSessionService;
		this.userRepository = userRepository;
		this.lessonRepo = lessonRepo;
	}

	@GetMapping("/index")
	public String viewIndex(){
		return "index";
	}

	@GetMapping("/loginform")
	public String login(Model model) {
		model.addAttribute("userModel", new User());
		return "loginform"; }


	@PostMapping(value = "login")
	public String handleLofinForm(
		@RequestParam("email") String email,
		@RequestParam("password") String password,
		RedirectAttributes redirectAttributes,
		HttpSession session,
		Model model)
	{boolean userLogged = userSessionService.loginUser(email, password,session);
	if(!userLogged){
			redirectAttributes.addFlashAttribute("message", "Niepoprawny email lub hasło");
			return "redirect:loginform/"; }
		else {
				String successfulLoginMessage="Zostałeś pomyślnie zalogowany";
				model.addAttribute("message",successfulLoginMessage);
				return "index"; } }


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutForm(HttpSession session){
		userSessionService.logout(session);
		return "index"; }

}