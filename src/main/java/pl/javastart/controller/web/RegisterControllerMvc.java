package pl.javastart.controller.web;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.javastart.model.Pupil;
import pl.javastart.model.RegisterKeyAndRoleDTO;
import pl.javastart.model.Role;
import pl.javastart.model.Teacher;
import pl.javastart.model.User;
import pl.javastart.repository.PupilRepository;
import pl.javastart.repository.RegisterKeyRepository;
import pl.javastart.repository.TeacherRepository;
import pl.javastart.repository.UserRepository;

@Controller
@RequestMapping("/registerUser")
public class RegisterControllerMvc {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PupilRepository pupilRepo;
	@Autowired
	public RegisterKeyRepository registerKeyRepo;
	@Autowired
	public RegisterControllerMvc(PupilRepository pupilRepo)
	{
		this.pupilRepo=pupilRepo;
	}
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	public RegisterControllerMvc(TeacherRepository teacherRepo)
	{
		this.teacherRepo=teacherRepo;
	}
	 @PostMapping
	 public String registerKey(@ModelAttribute @Valid RegisterKeyAndRoleDTO userRegisterDTO, Model model)
	 {
		 User user = new User();
		 Set<Role> roles;
//		 user.setRoles(roles);
		 Set<Role> roleName= registerKeyRepo.findRegisterKeyRoleName(userRegisterDTO.getKeyRegisterValue());  
		 for(Role r :roleName)
		 {
			 if(r.equals("nauczyciel"))
				{
				 model.addAttribute("userRegistrationDto",userRegisterDTO);
				 System.out.println(userRegisterDTO.getClassName() + " ----numer klasy");
				 System.out.println(userRegisterDTO.getKeyRegisterValue() +"------key register");
				 System.out.println("wchodzi do rejesestracji");
				 Pupil pupil = new Pupil();
				
				
				 user.setUsername(userRegisterDTO.getLogin());
				 user.setPassword(userRegisterDTO.getPassword());
				 user.setRoles(roleName);
//				 userRepo.save(user);
			
				 pupil.setClassName(userRegisterDTO.getClassName());
				 pupil.setFirstName(userRegisterDTO.getFirstName());
				 pupil.setKeyRegisterValue(userRegisterDTO.getKeyRegisterValue());
				 pupil.setLastName(userRegisterDTO.getLastName());
				 pupil.setPesel(userRegisterDTO.getPesel());
				 pupil.setLogin(userRegisterDTO.getLogin());
				 pupil.setPassword(userRegisterDTO.getPassword());
				 
				 pupil.setUser(user);
				 pupilRepo.save(pupil);
				 
				 model.addAttribute("userModel", new User());	
				 return "/loginform";
				}
		 
		
		 
		
		 if(r.getRoleName().equals("uczen"))
		 {
		 model.addAttribute("userRegistrationDto",userRegisterDTO);
		 System.out.println(userRegisterDTO.getKeyRegisterValue() +"------key register");
		 System.out.println("wchodzi do rejesestracji");
		 Teacher teacher = new Teacher();
		 
		 
		 user.setUsername(userRegisterDTO.getLogin());
		 user.setPassword(userRegisterDTO.getPassword());
		 
		 user.setRoles(roleName);
		 
		 userRepo.save(user);
		 
		 teacher.setFirstName(userRegisterDTO.getFirstName());
		 teacher.setKeyRegisterValue(userRegisterDTO.getKeyRegisterValue());
		 teacher.setLastName(userRegisterDTO.getLastName());
		 teacher.setPesel(userRegisterDTO.getPesel());
		 teacher.setLogin(userRegisterDTO.getLogin());
		 teacher.setPassword(userRegisterDTO.getPassword());
		 teacher.setUser(user);
		 teacherRepo.save(teacher);
		
			model.addAttribute("userModel", new User());	
		 return "/loginform";
		}
		 return "/login";
		 
	 }
		return null;
		
	 }
}


