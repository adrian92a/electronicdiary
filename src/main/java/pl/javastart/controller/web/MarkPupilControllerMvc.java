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
import pl.javastart.model.TeacherDTO;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.MarkRepository;
import pl.javastart.repository.PupilRepository;
import pl.javastart.repository.TeacherRepository;

@Controller
public class MarkPupilControllerMvc {
	private static final int Mark = 0;
	
	@Autowired
	TeacherRepository teacherRepo;
	
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
		Integer numerNauczyciela = lessonRepo.findTeacher(pupilRepo.szukajId(email),subjectType.toString());
	
		
		String teacherFirstName=teacherRepo.findFirstNameTeacher(numerNauczyciela);
		String teacherLastName= teacherRepo.findLastNameTeacher(numerNauczyciela);
	
		TeacherDTO teacher = new TeacherDTO(teacherFirstName,teacherLastName);
		model.addAttribute("teacherFirstName",teacher.getFirstName());
		model.addAttribute("teacherLastName",teacher.getLasName());
		
		for (Object[] obj : lessonRepo.findValuesToMarkTable(pupilRepo.szukajId(email),subjectType.toString())) 
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
}
