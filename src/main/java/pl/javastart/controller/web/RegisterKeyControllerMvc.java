package pl.javastart.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.javastart.model.Pupil;
import pl.javastart.model.RegisterKey;
import pl.javastart.model.User;
import pl.javastart.repository.RegisterKeyRepository;


@Controller
@RequestMapping("/registerKeyController")
public class RegisterKeyControllerMvc {
	
	RegisterKey  registerkey;

	

	private RegisterKeyRepository registerKeyRepo;
	
	@Autowired
	public RegisterKeyControllerMvc(RegisterKeyRepository registerKeyRepo)
	{
		this.registerKeyRepo=registerKeyRepo;
	}

	public boolean existRegisterKey(String key)
	{
		
	     List<RegisterKey> registerkeys = registerKeyRepo.findAll();
	     
	
		for(RegisterKey registerkey : registerkeys )
		{
			if(registerkey.getKeyRegisterValue().equals(key))
			{
				return true;
			}		
		}
		return false;
	}
	
	 @PostMapping
	public String redirectKey(@ModelAttribute RegisterKey registerKey, Model model)
	{
		if(existRegisterKey(registerKey.getKeyRegisterValue()))
		{
			model.addAttribute("RegisterKey", registerKey);
			model.addAttribute("RegisterKeyFirstName", registerKey.getFirstName());

			return "registrationpanel";
		}
		  return "redirect:/";
	} 
	
}
