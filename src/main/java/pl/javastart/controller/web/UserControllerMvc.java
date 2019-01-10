package pl.javastart.controller.web;



import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.javastart.model.Pupil;
import pl.javastart.model.RegisterKey;
import pl.javastart.model.Role;
import pl.javastart.model.User;
import pl.javastart.repository.RoleRepository;
import pl.javastart.repository.UsersRepository;

@Controller
@RequestMapping("/adduser")
public class UserControllerMvc 
{
	
	
	
    private UsersRepository userRepo ;
    private RoleRepository roleRepo ;
    
  @Autowired 
    public UserControllerMvc(UsersRepository userRepo, RoleRepository roleRepo) {
	super();
	this.userRepo = userRepo;
	this.roleRepo = roleRepo;
}

	User user= new User("adrian", "skorupa");
	
	Role role= new Role("admin");
	
	public int findRole(Role role)
	{
		return roleRepo.findIdByRoleName(role.getRoleName());
	}

	@PostMapping
    public String addUser(@ModelAttribute User userModel,  RedirectAttributes redirectAttr) 
    {   
		User user= new User("adrian", "skorupa");
		
		Role role= new Role("admin");
		user.setRole(role);
		userRepo.save(user);
    

 
        return "redirect:/";
        
    }
	

}