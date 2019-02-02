package pl.javastart.controller.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.javastart.model.Lesson;
import pl.javastart.model.Mark;
import pl.javastart.model.MarksDTO;
import pl.javastart.model.Pupil;
import pl.javastart.model.SubjectType;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.MarkRepository;
import pl.javastart.repository.PupilRepository;

@Controller
public class MarkPupilControllerMvc {
	private static final int Mark = 0;
	

	@Autowired
	AccountController accountController;
	@Autowired
	private PupilRepository pupilRepo;

	@Autowired
	private LessonRepository lessonRepo;
	
	@Autowired
	private MarkRepository markRepo;
	public String email(HttpSession session) 
	{
		System.out.println("------------email(HttpSession session)");
	return (String) session.getAttribute("email");
	}

//	List<MarksDTO> userMarks;
//	    public HashSet<Object> listMarks(String pupilName) 
//	    {
//		  
//		System.out.println("----------- "+(accountController));
//		   System.out.println("----------- wchodzi do ListMarks");
//
//	        int markValue;
//	        String email;
//		   List<Object[]> markPupil=  markRepo.findMark(pupilName);
//		   for (Object[] obj : markPupil) {
//			     markValue =  (int) obj[0];
//			     email = (String) obj[1];
//			     pupilsMarks.add(obj);
//			}		   
//	        System.out.println("----------- wchodzi do pętli 1");
//			return pupilsMarks;
//	    }
	    
	    
@GetMapping(value = "/subjects")
public String showSubjects(HttpSession session, @RequestParam(required = false) 
String query, @RequestParam(required = false) String subjectType, 
ModelMap model)
{

		model.addAttribute("selectedsubjectType", subjectType);

		String email=(String) session.getAttribute("email");
		
		Integer markValue;
		String markPurpose;
		Integer markWeight;
		HashSet<Object> pupilsMarks = new HashSet<Object>(); 
		for (Object[] obj : lessonRepo.find(pupilRepo.szukajId(email),subjectType.toString())) 
		{
		    markValue =   (int) obj[0];
		  
		    System.out.println(markValue);
		}
		for (Object[] obj : lessonRepo.find(pupilRepo.szukajId(email),subjectType.toString())) 
		{
		    markValue =   (int) obj[0];
		    markPurpose =  (String) obj[1];
		    markWeight =  (int) obj[2];
	
	    MarksDTO mark = new MarksDTO(markValue,markPurpose,markWeight); 
		    pupilsMarks.add(mark);
		}		
		model.addAttribute("userMarks",pupilsMarks);
		return "checkmarks";

}
	    
	    
	    
//	    @RequestMapping("/checkmarks")
//	  public String getMoviesOrdered(@RequestBody Lesson lesson, 
//			  @RequestParam String myselect, Model model){
//		  System.out.println("subjectType");
//		    return "index";
//		}
	  
//	  
//	    @RequestMapping(value="/checkmarks", method = RequestMethod.GET)
//	    public String pupilMarks(HttpSession session,RedirectAttributes redirectAttr) 
//	    {   
//	    	System.out.println("----------"+accountController.userName(session).toString());
//	        return "/checkmarks";
//	    }
//	    @GetMapping
//	    public String listCities(Model model) {
//	        List<String> subjects = lessonRepo.findDistinctSubject();
//	        model.addAttribute("subjectNames",subjects );
//	        return "list";
//	    }
}
