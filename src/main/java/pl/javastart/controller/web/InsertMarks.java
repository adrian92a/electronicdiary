package pl.javastart.controller.web;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.javastart.model.ClassDTO;
import pl.javastart.model.ClassForm;

import pl.javastart.model.MarksDTO;
import pl.javastart.model.PersonForm;
import pl.javastart.model.PupilDTO;
import pl.javastart.model.RegisterKeyAndRoleDTO;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.PupilRepository;
import pl.javastart.repository.TeacherRepository;
import pl.javastart.repository.UserRepository;

@Controller
public class InsertMarks {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private LessonRepository lessonRepo;

	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private PupilRepository pupilRepo;
	
//	@RequestMapping(value = "/insertmarks", method = RequestMethod.GET)
//    public String home(Model model,HttpSession session) {
//    	
//    	String email=(String) session.getAttribute("email");
//    	
//    	System.out.println(email+ " ------email");
//    	
//	//System.out.println(userRepo.findUserByEmail(email));
//	//System.out.println(teacherRepo.findTeacherID(userRepo.findUserByEmail(email)));
//	lessonRepo.findTeacherClass(teacherRepo.findTeacherID(userRepo.findUserByEmail(email)));
//	
//	HashSet<Object> classTeacher = new HashSet<Object>(); 
//	 Integer classId;
//	 Integer classNumber;
//	 String classLetter;
//	for(Object[] obj : lessonRepo.findTeacherClass(teacherRepo.findTeacherID(userRepo.findUserByEmail(email)))) 
//	{
//		classId =   (Integer) obj[0];
//		classNumber =  (Integer) obj[1];
//		classLetter = (String) obj[2];
//		MarksDTO cl = new MarksDTO(classId,classLetter,classNumber); 
//		classTeacher.add(cl);
//		
//		System.out.println(classId);
//		System.out.println(classNumber);
//		System.out.println(classLetter);
//	}
//	ClassForm form = new ClassForm();
//    model.addAttribute("classForm", form);
//	model.addAttribute("classTeacher", classTeacher);
//			
//	
//    return "insertmarks";
//}  
//	@Autowired
//	private CountryDAO countryDAO;
//	
//	@RequestMapping(value = { "/selectOptionExample1" },  method = RequestMethod.GET)
//	public String selectOptionExample1Page(HttpSession session, Model model) {
//	 
//	    PersonForm form = new PersonForm();
//	    model.addAttribute("personForm", form);
//	
//	  
//		List<Country> list = countryDAO.getCountries(session);
//	    model.addAttribute("countries", list);
//	 
//	    return "selectOptionExample1";
//	}
	
	@Autowired
	private ClassDAO classDAO;
	
	@GetMapping(value ="/selectformget")
	public String selectform(HttpSession session, Model model) {
	 
	    ClassForm form = new ClassForm(); 	
	    model.addAttribute("classForm", form);
	
	  
		List<ClassDTO> list = classDAO.getCountries(session);
	    model.addAttribute("classes", list);
	 
	    return "selectform";
	}
	
	
	@PostMapping("/selectedClass")
	public String save(HttpSession session,@RequestParam("classId") Integer classID, Model model)
	{
		  ClassForm form = new ClassForm();
		    model.addAttribute("classForm", form);
		
		  
			List<ClassDTO> list = classDAO.getCountries(session);
		    model.addAttribute("classes", list);
		    
		    Integer pupilId;;
			String pupilFirstName;
			String pupilLastName;
			HashSet<Object> pupilList = new HashSet<Object>(); 		
		    for (Object[] obj : pupilRepo.findPupilListFromClass(classID))
			{
		    	pupilId =   (int) obj[0];
			    pupilFirstName =  (String) obj[1];
			    pupilLastName =  (String) obj[2];
				System.out.println(pupilFirstName);
		    PupilDTO pupil = new PupilDTO(pupilId,pupilFirstName,pupilLastName); 
		    pupilList.add(pupil);
			}		
		    
		    model.addAttribute("pupilList",pupilList);
		    
		System.out.println(classID);
		return "selectform";
	}
	
//	@GetMapping("/addMarksForm")
//	public String saveMarks(HttpSession session)
	
//	@PostMapping("/addMarks")
//	public String saveMarks(HttpSession session)
	
	
}

	
