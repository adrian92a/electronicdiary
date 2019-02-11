package pl.javastart.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pl.javastart.model.*;

@Controller
public class Register {
	 @GetMapping("/register")
	    public String register(Model model) {
		 model.addAttribute("userDTO", new UserDTO());

	 	return "register";
	    }

	}

