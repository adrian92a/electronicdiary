package pl.javastart.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeMenu {

		 @GetMapping("/home")
	    public String homeMenu()
		 {
	        return "home";
	
		 }
		 @GetMapping("/")
		    public String homeMenu2()
			 {
		        return "home";
		
			 }
	}

