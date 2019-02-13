 package pl.javastart.controller.web;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.model.*;
import pl.javastart.repository.PupilRepository;
import pl.javastart.repository.RegisterKeyRepository;
import pl.javastart.repository.RoleRepository;
import pl.javastart.repository.SchoolClassRepository;
import pl.javastart.repository.TeacherRepository;
import pl.javastart.repository.UserRepository;


@Controller
public class RegistrationSubmitUserData {
	@Autowired
	private SchoolClassRepository schoolRepo;

	@Autowired
	private RegisterKeyRepository registerKeyRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PupilRepository pupilRepo;
	@Autowired
	UserService userService= new UserService();
	@Autowired
	public RegistrationSubmitUserData(PupilRepository pupilRepo) {
		this.pupilRepo = pupilRepo;
	}

	@Autowired
	private TeacherRepository teacherRepo;


	public RegistrationSubmitUserData(TeacherRepository teacherRepo) {
		this.teacherRepo = teacherRepo;
	}


	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	 public String registerUserAccount (@ModelAttribute @Valid RegisterKeyAndRoleDTO userRegisterDTO,BindingResult result,
											  Model model)
		 {
			 Set<Role> roles= registerKeyRepo.findRegisterKeyRoleName(userRegisterDTO.getKeyRegisterValue());
			for(Role r:roles)
			{
					if(r.getRoleName().equals("uczeń")) {
						Pupil pupil = new Pupil();
						pupil.setFirstName(userRegisterDTO.getFirstName());
						pupil.setLastName(userRegisterDTO.getLastName());
						pupil.setPesel(userRegisterDTO.getPesel());
						Schollclass scholl = schoolRepo.findSchollclassByClassNumberAndClassLetter(userRegisterDTO.getSchollClassnumber(), userRegisterDTO.getSchollClassLetter());

						pupil.setSchollclass(scholl);

						User user=new User(userRegisterDTO.getEmail(),userRegisterDTO.getPassword());
						user.setRole(r);
						pupil.setUser(user);
						userRepo.save(user);
						pupilRepo.save(pupil);
						return setRegisterKeyUsedValueAndRedirect(userRegisterDTO);
					}

					if(r.getRoleName().equals("nauczyciel"))
					{
						Teacher teacher =new Teacher();
						teacher.setFirstName(userRegisterDTO.getFirstName());
						teacher.setLastName(userRegisterDTO.getLastName());
						teacher.setPesel(userRegisterDTO.getPesel());


						User user=new User(userRegisterDTO.getEmail(),userRegisterDTO.getPassword());
						user.setRole(r);
						teacher.setUser(user);
						userRepo.save(user);
						teacherRepo.save(teacher);
						return setRegisterKeyUsedValueAndRedirect(userRegisterDTO);
					}
				}
			return null;
			}
	private String setRegisterKeyUsedValueAndRedirect(@Valid @ModelAttribute RegisterKeyAndRoleDTO userRegisterDTO) {
		RegisterKey key = registerKeyRepo.findByRegisterey(userRegisterDTO.getKeyRegisterValue());
		key.setUsed(true);
		registerKeyRepo.save(key);
		return "loginform";
	}
}