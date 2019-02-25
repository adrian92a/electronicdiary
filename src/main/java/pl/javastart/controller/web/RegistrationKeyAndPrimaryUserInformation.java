package pl.javastart.controller.web;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.javastart.model.*;
import pl.javastart.repository.RegisterKeyRepository;
import pl.javastart.repository.UserRepository;
import pl.javastart.serive.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/registerKeyController")
public class RegistrationKeyAndPrimaryUserInformation {
	public String error;

	private RegisterKeyRepository registerKeyRepo;
	private UserService userService;
	private UserRepository userRepo;


	public RegistrationKeyAndPrimaryUserInformation(RegisterKeyRepository registerKeyRepo, UserService userService, UserRepository userRepo) {
		this.registerKeyRepo = registerKeyRepo;
		this.userService = userService;
		this.userRepo = userRepo;
	}



	public boolean existRegisterKeyAndIsntUsed(String key)
	{
	 List<RegisterKey> registerkeys =  registerKeyRepo.findAll();
	 for(RegisterKey registerkey : registerkeys )
		{
			if(registerkey.getKeyRegisterValue().equals(key))
			{
				if(registerkey.getUsed()==false)
				{
					return true;
				}
			}
		} 
		return false;
	}
	@RequestMapping(method = RequestMethod.POST)
	public String redirectKey(@Valid UserDTO userDTO, BindingResult result,Model model)
	{
		if(!existRegisterKeyAndIsntUsed(userDTO.getRegisterKey()) ){
			result.addError(new FieldError("registerKey","registerKey","Kod jest niepoprany lub zostal juz wykorzystany do rejestracji"));
		}
		if (result.hasErrors()) {
			return "register";
		}
		if(existRegisterKeyAndIsntUsed(userDTO.getRegisterKey()) )
		{
			Set<Role> roles= registerKeyRepo.findRegisterKeyRoleName(userDTO.getRegisterKey());
			for(Role r:roles)
			{
				RegisterKey registerKey2 = registerKeyRepo.findByRegisterey(userDTO.getRegisterKey());
				RegisterKeyAndRoleDTO registerKeyAndRoleDTO = getRegisterKeyAndRoleDTO(userDTO, roles, registerKey2);
				userDTO.setRole(r);
				User user= userService.registerNewUserAccount(userDTO);
				System.out.println("user-------"+user);
				if(user==null) {
					result.addError(new FieldError("email", "email", "Podany e-mail: " + '"' + userDTO.getEmail() + '"' + "  jest już zajęty"));
				}
				else{
					registerKeyAndRoleDTO.setPassword(userDTO.getPassword());
					registerKeyAndRoleDTO.setEmail(userDTO.getEmail());

					if (r.getRoleName().equals("uczeń")) {
						registerKeyAndRoleDTO.setRoleId(2);
						model.addAttribute("RegisterKeyAndRoleDTO", registerKeyAndRoleDTO);
						return "pupilsubmitregistrationpanel";
					}
					if (r.getRoleName().equals("nauczyciel")) {
						registerKeyAndRoleDTO.setRoleId(1);
						model.addAttribute("RegisterKeyAndRoleDTO", registerKeyAndRoleDTO);
						return "teachersubmitregistrationpanel";
					}
				}
			}
		}
		else
		{
			result.addError(new FieldError("registerKey","registerKey","Kod jest niepoprany lub zostal juz wykorzystany do rejestracji"));
		}
		return "/register";
	}

	private RegisterKeyAndRoleDTO getRegisterKeyAndRoleDTO(@Valid UserDTO userDTO, Set<Role> roles, RegisterKey registerKey2) {
		RegisterKeyAndRoleDTO registerKeyAndRoleDTO = new RegisterKeyAndRoleDTO();
		registerKeyAndRoleDTO.setKeyRegisterValue(registerKey2.getKeyRegisterValue());
		registerKeyAndRoleDTO.setFirstName(registerKey2.getFirstName());
		registerKeyAndRoleDTO.setLastName(registerKey2.getLastName());
		registerKeyAndRoleDTO.setPesel(registerKey2.getPesel());
		registerKeyAndRoleDTO.setRoleName(roles);
		registerKeyAndRoleDTO.setSchollClassLetter(registerKey2.getSchollClassLetter());
		registerKeyAndRoleDTO.setSchollClassnumber(registerKey2.getSchollClassnumber());
		registerKeyAndRoleDTO.setEmail(userDTO.getEmail());
		registerKeyAndRoleDTO.setPassword(userDTO.getPassword());

		return registerKeyAndRoleDTO;
	}
}
