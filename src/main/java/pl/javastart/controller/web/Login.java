package pl.javastart.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.javastart.model.Pupil;
import pl.javastart.model.User;
@Controller
public class Login {
	 @GetMapping("/login")
	    public String registerUser(Model model) {
		  model.addAttribute("userModel", new User());
	        return "login";
	    } 
}
