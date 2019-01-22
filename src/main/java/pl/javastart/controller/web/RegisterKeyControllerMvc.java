package pl.javastart.controller.web;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.javastart.model.RegisterKey;
import pl.javastart.model.RegisterKeyAndRoleDTO;
import pl.javastart.model.Role;
import pl.javastart.repository.RegisterKeyRepository;
import pl.javastart.repository.RoleRepository;



@Controller
@RequestMapping("/registerKeyController")
public class RegisterKeyControllerMvc {
	public String error;
	@Autowired
	public RegisterKeyRepository registerKeyRepo;
	
	@Autowired
	public RoleRepository roleRepo;
	
	@Autowired
	public RegisterKeyControllerMvc(RegisterKeyRepository registerKeyRepo)
	{
		this.registerKeyRepo=registerKeyRepo;
	}

	public boolean existRegisterKeyAndIsntUsed(String key)
	{
	 List<RegisterKey> registerkeys = (List<RegisterKey>) registerKeyRepo.findAll();
	 for(RegisterKey registerkey : registerkeys )
		{
		 System.out.println(registerkey);
			if(registerkey.getKeyRegisterValue().equals(key) 	)
//					&& registerkey.getUsed())
			{
				return true;
			}
			if(registerkey.getKeyRegisterValue().equals(key))
			{
				return true;
			}
		} 
		return true;
	}
	 private static void selectKeyUser(String key)
	 {}
		public int findRole(Role role)
		{
			return roleRepo.findIdByRoleName(role.getRoleName());
		}
	 @PostMapping
	public String redirectKey(@ModelAttribute RegisterKeyAndRoleDTO  registerKey, Model model)
	{
		if(existRegisterKeyAndIsntUsed(registerKey.getKeyRegisterValue()) )
		{
			Set<Role> roles= registerKeyRepo.findRegisterKeyRoleName(registerKey.getKeyRegisterValue());
			for(Role r:roles)
			{
				
				RegisterKey registerKey2 = registerKeyRepo.findByRegisterey(registerKey.getKeyRegisterValue());
				RegisterKeyAndRoleDTO registerKeyAndRoleDTO = new RegisterKeyAndRoleDTO();	
				registerKeyAndRoleDTO.setKeyRegisterValue(registerKey2.getKeyRegisterValue());
				registerKeyAndRoleDTO.setFirstName(registerKey2.getFirstName());
				registerKeyAndRoleDTO.setLastName(registerKey2.getLastName());
				registerKeyAndRoleDTO.setPesel(registerKey2.getPesel());
				registerKeyAndRoleDTO.setRoleName(roles);		
				registerKeyAndRoleDTO.setLogin(null);
				registerKeyAndRoleDTO.setPassword(null);
				if(r.getRoleName().equals("uczen"))
				{
					registerKeyAndRoleDTO.setClassName(registerKey2.getClassName());;
					model.addAttribute("RegisterKeyAndRoleDTO", registerKeyAndRoleDTO);
					return "pupilsubmitregistrationpanel";
				}	
				if(r.getRoleName().equals("nauczyciel"))
				{
					registerKeyAndRoleDTO.setClassName(registerKey2.getClassName());;
					model.addAttribute("RegisterKeyAndRoleDTO", registerKeyAndRoleDTO);
					return "teachersubmitregistrationpanel";
				}
			}
		}
		RegisterKeyAndRoleDTO registerKeyAndRoleDTO = new RegisterKeyAndRoleDTO();	
		registerKeyAndRoleDTO.setKeyError("Kod jest niepoprawny lub został już wykorzystany do rejestracji");
		System.out.println("----Niepoprawny kod");
		model.addAttribute("keyRegisterModel", registerKeyAndRoleDTO);	
        return "/register";
	}
}
