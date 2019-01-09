package pl.javastart.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.javastart.model.RegisterKey;

@Controller
@RequestMapping("/userAdditionalData")
public class RegisterAdditionalDataMvc {
	 @PostMapping
		public String web()
		{
		 return "useradditionaldata";
		}
}
