package pl.javastart.controller.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.javastart.model.RegisterKeyAndRoleDTO;
import pl.javastart.model.User;
import pl.javastart.security.CustomUserDetailsService;

@Controller
@RequestMapping("/loginController")
public class LoginController {
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@PostMapping
	 public String loginIn(@ModelAttribute User user, Model model)
    {
		
	System.out.println("------LoginController " +user.getUsername());
	UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getUsername());
	System.out.println("-------user details "+userDetails.getUsername());
	System.out.println("-------user details "+userDetails.getPassword());
	return "home";


		
	
	}
}
