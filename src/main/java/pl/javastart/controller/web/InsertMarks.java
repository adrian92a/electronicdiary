package pl.javastart.controller.web;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

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
import pl.javastart.model.Lesson;
import pl.javastart.model.Mark;
import pl.javastart.model.MarksDTO;
import pl.javastart.model.PersonForm;
import pl.javastart.model.Pupil;
import pl.javastart.model.PupilDTO;
import pl.javastart.model.RegisterKeyAndRoleDTO;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.MarkRepository;
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
	private MarkRepository markRepo;
	
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
	public String save(HttpSession session,@RequestParam("lessonId") Integer lessonId, Model model)
	{
			ClassForm form = new ClassForm();
		    model.addAttribute("classForm", form);
		
		
			List<ClassDTO> list = classDAO.getCountries(session);
		    model.addAttribute("classes", list);
		    
		    String email=(String) session.getAttribute("email");
		    
		    Integer pupilId;
			String pupilFirstName;
			String pupilLastName;
			Integer pupilLessonId;
		//	Integer lessonId = lessonRepo.findLessonId(classID, teacherRepo.findTeacherIdByEmail(email), subjectName)
			
		//	lessonId.getClassId();
			int index=0;
			TreeSet<Object> pupilList = new TreeSet<Object>(); 	
			
		    for (Object[] obj : pupilRepo.findPupilListFromClass(lessonId))
			{
		    	pupilLessonId=lessonId;
		    	index= index+1;
		    	System.out.println("index----------------   "   +index);
		    	pupilId =   (int) obj[0];
			    pupilFirstName =  (String) obj[1];
			    pupilLastName =  (String) obj[2];
			    
				System.out.println(pupilFirstName);
		    PupilDTO pupil = new PupilDTO(index,pupilId,pupilFirstName,pupilLastName,lessonId); 
		    pupilList.add(pupil);
			}		
		 
		    model.addAttribute("pupilList",pupilList);
		    
		System.out.println(lessonId);
		return "selectform";
	}
	@RequestMapping("/insertOneMark")
	public String insertMark(HttpSession session,@RequestParam("lessonId") Integer lessonId,
			@RequestParam("firstName") String firstName,
			@RequestParam("pupilId") Integer pupilId,
			@RequestParam("lastName") String lastName,
			@RequestParam("mark") Integer mark,
			@RequestParam("description") String description,
			@RequestParam("markWeight") Integer markWeight,
			Model model)
	{
		Lesson lesson=new Lesson();
		lesson=lessonRepo.getOne(lessonId);
		Pupil pupil= new Pupil();
		pupil = pupilRepo.getOne(pupilId);
		
		Mark insertMark= new Mark(mark,markWeight,description);
		insertMark.setLesson(lesson);
		insertMark.setPupil(pupil);
		
		markRepo.save(insertMark);
		System.out.println(description);
		return "index";
		
	}
	
}

	
