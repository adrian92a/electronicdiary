package pl.javastart.controller.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.javastart.model.Pupil;
import pl.javastart.model.RegisterKeyAndRoleDTO;
import pl.javastart.model.Teacher;
import pl.javastart.repository.PupilRepository;
import pl.javastart.repository.RegisterKeyRepository;
import pl.javastart.repository.TeacherRepository;

@Controller
@RequestMapping("/registerUser")
public class RegisterControllerMvc {
	
	
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
		if(userRegisterDTO.getRoleName().equals("uczeń"))
		{
		 model.addAttribute("userRegistrationDto",userRegisterDTO);
		 System.out.println(userRegisterDTO.getClassName() + " ----numer klasy");
		 System.out.println(userRegisterDTO.getKeyRegisterValue() +"------key register");
		 System.out.println("wchodzi do rejesestracji");
		 Pupil pupil = new Pupil();
		 pupil.setClassName(userRegisterDTO.getClassName());
		 pupil.setFirstName(userRegisterDTO.getFirstName());
		 pupil.setKeyRegisterValue(userRegisterDTO.getKeyRegisterValue());
		 pupil.setLastName(userRegisterDTO.getLastName());
		 pupil.setPesel(userRegisterDTO.getPesel());
		 pupil.setRoleName(userRegisterDTO.getRoleName());
		 pupil.setLogin(userRegisterDTO.getLogin());
		 pupil.setPassword(userRegisterDTO.getPassword());
		 pupilRepo.save(pupil);
		 return "/login";
		}
		if(userRegisterDTO.getRoleName().equals("nauczyciel"))
		{
		 model.addAttribute("userRegistrationDto",userRegisterDTO);
		 System.out.println(userRegisterDTO.getKeyRegisterValue() +"------key register");
		 System.out.println("wchodzi do rejesestracji");
		 Teacher teacher = new Teacher();
		 teacher.setFirstName(userRegisterDTO.getFirstName());
		 teacher.setKeyRegisterValue(userRegisterDTO.getKeyRegisterValue());
		 teacher.setLastName(userRegisterDTO.getLastName());
		 teacher.setPesel(userRegisterDTO.getPesel());
		 teacher.setRoleName(userRegisterDTO.getRoleName());
		 teacher.setLogin(userRegisterDTO.getLogin());
		 teacher.setPassword(userRegisterDTO.getPassword());
		 teacherRepo.save(teacher);
		 return "/login";
		}
		 return "/login";
		 
	 }
}
