package pl.javastart.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import pl.javastart.model.RegisterKey;
import pl.javastart.model.Role;

@Controller
public class Register {
	 @GetMapping("/register")
	    public String registerUser(Model model) {
		  model.addAttribute("keyRegisterModel", new RegisterKey());
	
	        return "register";
	    } 
}
