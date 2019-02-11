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
public class RegisterControllerMvc {
	@Autowired
	private SchoolClassRepository schoolRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private RegisterKeyRepository registerKeyRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PupilRepository pupilRepo;
	@Autowired
	UserService userService= new UserService();
	@Autowired
	public RegisterControllerMvc(PupilRepository pupilRepo) {
		this.pupilRepo = pupilRepo;
	}

	@Autowired
	private TeacherRepository teacherRepo;

	public RegisterControllerMvc(TeacherRepository teacherRepo) {
		this.teacherRepo = teacherRepo;
	}

	public User createUserAccount(UserDTO accountDto)
	{
		User registered = null;
		try {
			registered = userService.registerNewUserAccount(accountDto);
		} catch (EmailExistsException e) {
			return null;
		}
		return registered;
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
							User user=userRegisterDTO.getUser();
							pupil.setUser(user);
						System.out.println("pupil---------"+pupil);

							pupilRepo.save(pupil);
							RegisterKey key = registerKeyRepo.findByRegisterey(userRegisterDTO.getKeyRegisterValue());
							key.setUsed(false);
							registerKeyRepo.save(key);
							return "loginform";
					}

					if(r.getRoleName().equals("nauczyciel"))
					{
						model.addAttribute("userRegistrationDto", userRegisterDTO);
						Role role = roleRepo.getOne(1l);

						UserDTO accountDto = new UserDTO();
						accountDto.setEmail(userRegisterDTO.getEmail());
						accountDto.setPassword(userRegisterDTO.getPassword());
						accountDto.setRole(role);
					}
				}
			return null;
			}
}
