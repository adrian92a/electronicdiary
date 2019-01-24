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
import pl.javastart.model.Schollclass;
import pl.javastart.model.Teacher;
import pl.javastart.model.User;
import pl.javastart.repository.PupilRepository;
import pl.javastart.repository.RegisterKeyRepository;
import pl.javastart.repository.RoleRepository;
import pl.javastart.repository.SchoolClassRepository;
import pl.javastart.repository.TeacherRepository;
import pl.javastart.repository.UserRepository;
import pl.javastart.security.UserService;

@Controller
@RequestMapping("/registerUser")
public class RegisterControllerMvc {
	@Autowired
	private SchoolClassRepository schoolRepo;
	
	@Autowired
	private UserService	userService;
	
	@Autowired
	private RoleRepository	roleRepo;
	
	@Autowired
	private RegisterKeyRepository registerKeyRepo;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PupilRepository pupilRepo;

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
		 Set<Role> roles= registerKeyRepo.findRegisterKeyRoleName(userRegisterDTO.getKeyRegisterValue());
			for(Role r:roles)
			{
		if(r.getRoleName().equals("uczeń"))
		{
		 model.addAttribute("userRegistrationDto",userRegisterDTO);
		// System.out.println(userRegisterDTO.getSchoolClass() + " ----numer klasy");
		 System.out.println(userRegisterDTO.getKeyRegisterValue() +"------key register");
		 System.out.println("wchodzi do rejesestracji");
		 Pupil pupil = new Pupil();
		 
		 Role role= roleRepo.getOne(1l);
		 
		 User user = new User();
		 user.setUsername(userRegisterDTO.getLogin());
		 user.setPassword(userRegisterDTO.getPassword());
		 user.setEnabled(true);
		 
		 user.addRole(role);
			
		 userRepo.save(user);
	
		 
		 
	
		 
		 pupil.setFirstName(userRegisterDTO.getFirstName());
		 pupil.setLastName(userRegisterDTO.getLastName());
		 pupil.setPesel(userRegisterDTO.getPesel());

		 pupil.setUser(user);
		
		 System.out.println("--------------- "+userRegisterDTO.getSchollClassnumber());
		 System.out.println("--------------- "+ userRegisterDTO.getSchollClassLetter());
		 
		 
		 Schollclass scholl=schoolRepo.findSchollclassByClassNumberAndClassLetter(userRegisterDTO.getSchollClassnumber(),userRegisterDTO.getSchollClassLetter());
		 pupil.setSchollclass(scholl);
		 pupilRepo.save(pupil);
		 
		 
		 model.addAttribute("userModel", new User());	
		 return "/loginform";
		}
		if(r.getRoleName().equals("nauczyciel"))
		{
		 model.addAttribute("userRegistrationDto",userRegisterDTO);
		 System.out.println(userRegisterDTO.getKeyRegisterValue() +"------key register");
		 System.out.println("wchodzi do rejesestracji");
		 
		 
		
	
		 Role role= roleRepo.getOne(2l);
		 
	
		
		 User user = new User();
		 user.setUsername(userRegisterDTO.getLogin());
		 user.setPassword(userRegisterDTO.getPassword());
		 user.setEnabled(true);
		 System.out.println("------------Obiekt1");
		  user.addRole(role);
		 System.out.println("------------Obiekt2");
		 userRepo.save(user);
		System.out.println("------------Obiekt4");
		
		System.out.println("------------Obiekt5");
		
		
		 
		 
		
		 
		 
	//	 userService.addUser(user);
		 Teacher teacher = new Teacher();
		 teacher.setFirstName(userRegisterDTO.getFirstName());
		 teacher.setLastName(userRegisterDTO.getLastName());
		 teacher.setPesel(userRegisterDTO.getPesel());
		 
		 teacher.setUser(user);
		 teacherRepo.save(teacher);
		
			model.addAttribute("userModel", new User());	
		 return "/loginform";
		}
		
		 
	 }
			 return "/login";
}
}
