package pl.javastart.controller.web;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public RegisterKeyControllerMvc(RegisterKeyRepository registerKeyRepo)
	{
		this.registerKeyRepo=registerKeyRepo;
	}

	public boolean existRegisterKeyAndIsntUsed(String key)
	{
	 List<RegisterKey> registerkeys = (List<RegisterKey>) registerKeyRepo.findAll();
	 for(RegisterKey registerkey : registerkeys )
		{
		 System.out.println("---------------"+registerkey);
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
//	 private static void selectKeyUser(String key)
	 {}
//		public int findRole(Role role)
//		{
//			return roleRepo.findIdByRoleName(role.getRoleName());
//		}
	 @PostMapping
	public String redirectKey(@ModelAttribute RegisterKeyAndRoleDTO  registerKey, Model model)
	{
		 System.out.println("------------- 1");
		 System.out.println("----------Wartosc register Key	"+registerKey.getKeyRegisterValue());
		if(existRegisterKeyAndIsntUsed(registerKey.getKeyRegisterValue()) )
		{
			System.out.println("------------- 2");
			Set<Role> roles= registerKeyRepo.findRegisterKeyRoleName(registerKey.getKeyRegisterValue());
			for(Role r:roles)
			{
				
				
				System.out.println("-------------3");
				RegisterKey registerKey2 = registerKeyRepo.findByRegisterey(registerKey.getKeyRegisterValue());
				RegisterKeyAndRoleDTO registerKeyAndRoleDTO = new RegisterKeyAndRoleDTO();	
				registerKeyAndRoleDTO.setKeyRegisterValue(registerKey2.getKeyRegisterValue());
				registerKeyAndRoleDTO.setFirstName(registerKey2.getFirstName());
				registerKeyAndRoleDTO.setLastName(registerKey2.getLastName());
				registerKeyAndRoleDTO.setPesel(registerKey2.getPesel());
				registerKeyAndRoleDTO.setRoleName(roles);	
				System.out.println("--------------"+registerKey2.getSchollClassLetter());
				System.out.println("--------------"+registerKey2.getSchollClassnumber());
				registerKeyAndRoleDTO.setSchollClassLetter(registerKey2.getSchollClassLetter());
				registerKeyAndRoleDTO.setSchollClassnumber(registerKey2.getSchollClassnumber());
				registerKeyAndRoleDTO.setLogin(null);
				registerKeyAndRoleDTO.setPassword(null);
				if(r.getRoleName().equals("uczeń"))
				{
					model.addAttribute("RegisterKeyAndRoleDTO", registerKeyAndRoleDTO);
					return "pupilsubmitregistrationpanel";
				}	
				if(r.getRoleName().equals("nauczyciel"))
				{
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
