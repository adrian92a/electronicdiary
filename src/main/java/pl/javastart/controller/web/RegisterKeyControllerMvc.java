package pl.javastart.controller.web;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.javastart.model.RegisterKey;
import pl.javastart.model.Role;
import pl.javastart.repository.RegisterKeyRepository;
import pl.javastart.repository.RoleRepository;



@Controller
@RequestMapping("/registerKeyController")
public class RegisterKeyControllerMvc {

	public RegisterKey  registerkey;

	@Autowired
	public RegisterKeyRepository registerKeyRepo;
	
	@Autowired
	public RoleRepository roleRepo;
	
	@Autowired
	public RegisterKeyControllerMvc(RegisterKeyRepository registerKeyRepo)
	{
		this.registerKeyRepo=registerKeyRepo;
	}

	public boolean existRegisterKey(String key)
	{
		
	     List<RegisterKey> registerkeys = (List<RegisterKey>) registerKeyRepo.findAll();
	     
	
		for(RegisterKey registerkey : registerkeys )
		{
			if(registerkey.getKeyRegisterValue().equals(key))
			{
				return true;
			}		
		}
		return false;
	}
	 private static void selectKeyUser(String key)
	 {
		 
	 }

		public int findRole(Role role)
		{
			return roleRepo.findIdByRoleName(role.getRoleName());
		}
	@PostConstruct
	 @PostMapping
	public String redirectKey(@ModelAttribute RegisterKey registerKey, Model model)
	{
		if(existRegisterKey(registerKey.getKeyRegisterValue()))
		{
//			registerKeyRepo.getOne(registerKe n y.getId()); 		
//			RegisterKey userRegisterKey =registerKeyRepo.getOne(registerKey.getId());
			String roleName= registerKeyRepo.findRegisterKeyRoleName(registerKey.getKeyRegisterValue());
			RegisterKey registerKey2=registerKeyRepo.findByEmailAddress(registerKey.getKeyRegisterValue());
			model.addAttribute("RegisterKey", registerKey2);
			model.addAttribute("RegisterKeyRole",roleName);

			return "registrationpanel";
		}
		  return "redirect:/";
	}


	
}
