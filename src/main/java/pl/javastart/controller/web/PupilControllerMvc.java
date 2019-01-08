package pl.javastart.controller.web;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.javastart.model.Pupil;
import pl.javastart.repository.PupilRepository;

@Controller
@RequestMapping("/pupils")
public class PupilControllerMvc 
{
	@Autowired
    private UserValidation userValidation;
	
    private PupilRepository pupilRepo;

    @Autowired
    public PupilControllerMvc(PupilRepository pupilRepo)
    {
        this.pupilRepo = pupilRepo;
    }

    @GetMapping
    public String listPupils(Model model) 
    {
        List<Pupil> pupils = pupilRepo.findAll();
        model.addAttribute("pupilList", pupils);
        return "pupils";
    }
   
    @PostMapping
    public String addPupil(@ModelAttribute Pupil pupilModel, RedirectAttributes redirectAttr) 
    {   
    	Map<String, String> errorsMap = userValidation.validateUser(pupilModel);
    			
    	if(errorsMap.isEmpty())
    	{
    	pupilRepo.save(pupilModel);
    	System.out.println(pupilModel.getFirstName());
    	}
        redirectAttr.addFlashAttribute("message", "Pupil added successfuly");
        return "redirect:/";
        
    }
}