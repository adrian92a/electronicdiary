package pl.javastart.controller.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.DTO.RegisterKeyAndRoleDTO;
import pl.javastart.DTO.UserDTO;

import pl.javastart.model.RegisterKey.RegisterKey;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.RegisterKeyRepository;
import pl.javastart.repository.UserRepository;
import pl.javastart.service.UserContextService;
import pl.javastart.service.UserService;
import pl.javastart.service.UserSessionService;

import java.util.Optional;

@Controller
public class UserController {
	private UserContextService userContextService;
	private UserSessionService userSessionService;
	private UserRepository userRepository;
	private LessonRepository lessonRepo;
	private UserService userService;
	private RegisterKeyRepository registerKeyRepo;
	public UserController(UserContextService userContextService, UserSessionService userSessionService, UserRepository userRepository, LessonRepository lessonRepo, UserService userService, RegisterKeyRepository registerKeyRepo) {
		this.userContextService = userContextService;
		this.userSessionService = userSessionService;
		this.userRepository = userRepository;
		this.lessonRepo = lessonRepo;
		this.userService = userService;
		this.registerKeyRepo = registerKeyRepo;
	}
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "register"; }


	@GetMapping("/index")
	public String viewIndex(){
		return "index";
	}

	@GetMapping("/loginform")
	public String login(Model model) {
//		model.addAttribute("userModel", new User());
//		return "loginform"; }
			return "loginBySpring";
		}


	@PostMapping(value = "login")
	public String handleLofinForm(
		@RequestParam("email") String email,
		@RequestParam("password") String password,
		RedirectAttributes redirectAttributes,
		HttpSession session,
		Model model)
	{
		System.out.println("----------1"+password);
		boolean userLogged = userSessionService.loginUser(email, password,session);
	if(!userLogged){
			redirectAttributes.addFlashAttribute("message", "Niepoprawny email lub hasło");
			return "redirect:loginform/"; }
		else {
				String successfulLoginMessage="Zostałeś pomyślnie zalogowany";
				model.addAttribute("message",successfulLoginMessage);
				return "index"; } }


	@GetMapping("/login-by-spring")
	public String showLoginFormBySpringSecurity(){
		return "loginBySpring";
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutForm(HttpSession session){
		userSessionService.logout(session);
		return "index"; }

	@PostMapping("/registerUser")
	public String registerKeyView(@ModelAttribute RegisterKeyAndRoleDTO registerKeyAndRoleDTO, Model model)
	{

			userService.registerNewAccount(registerKeyAndRoleDTO);
			userService.setRegisterKeyUsedValueAndRedirect(registerKeyAndRoleDTO);
			return "loginform";




	}
	@RequestMapping(value = "register" , method = RequestMethod.POST)
	public String redirectKey( @ModelAttribute @Valid UserDTO userDTO, BindingResult result, Model model)
	{
		if(!userService.existRegisterKeyAndIsntUsed(userDTO.getRegisterKey()) ){
			result.addError(new FieldError("registerKey","registerKey","Kod jest niepoprany lub zostal juz wykorzystany do rejestracji"));
		}
		if (result.hasErrors()) {
			return "register";
		}
		if(!userService.emailDoesntExist(userDTO.getEmail()))
		{
			result.addError(new FieldError("email","email","Email jest już zajęty"));

			return "register";
		}
		if(userService.existRegisterKeyAndIsntUsed(userDTO.getRegisterKey()) )
		{
			System.out.println("REGISTER KEY =========="+userDTO.getRegisterKey());
			System.out.println("REGISTER KEY =========="+userDTO.getEmail());
			System.out.println("REGISTER KEY =========="+userDTO.getPassword());
			Optional<RegisterKey> registerKey= registerKeyRepo.findByKeyRegisterValue(userDTO.getRegisterKey());
			System.out.println("REGISTER KEY=============="+ registerKey.get().firstName);
			model.addAttribute("RegisterKeyAndRoleDTO",userService.getRegisterKeyAndRoleDTO(userDTO,registerKey.get()));
			return "/submitregistrationpanel";
		}
		return "/register";
	}
}