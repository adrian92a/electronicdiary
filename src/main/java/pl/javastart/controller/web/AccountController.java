package pl.javastart.controller.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.javastart.repository.UserRepository;

@Controller
//@RequestMapping(value = "account")
public class AccountController {
	@Autowired
	private PasswordEncoder passwordEncoder;
@Autowired
UserRepository userRepository;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		HttpSession session,
		ModelMap modelMap) {
		
		System.out.println("---------AccountController");
	
		 System.out.println(	passwordEncoder.encode(password) +"---------AccountController");
		System.out.println(userRepository.findLoginAndPassword(username,passwordEncoder.encode(password))+"---------AccountController");
//		if(username.equalsIgnoreCase("q") && password.equalsIgnoreCase("q"))
		if(userRepository.findLoginAndPassword(username,password)>0)
		{
			session.setAttribute("username", username);
			return "index";
		} else {
			modelMap.put("error", "Invalid Account");
			return "index";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "home";
	}

}