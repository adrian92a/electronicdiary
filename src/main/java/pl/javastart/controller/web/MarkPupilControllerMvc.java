package pl.javastart.controller.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.model.MarksDTO;
import pl.javastart.model.TeacherDTO;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.MarkRepository;
import pl.javastart.repository.PupilRepository;
import pl.javastart.repository.TeacherRepository;

import javax.servlet.http.HttpSession;
import java.util.HashSet;

@Controller
public class MarkPupilControllerMvc {
	private static final int Mark = 0;
	
	@Autowired
	TeacherRepository teacherRepo;
	
	@Autowired
	UserController userController;
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
public String showSubjects(HttpSession session, @RequestParam("subjectType") String subjectType,
ModelMap model)
	{

		model.addAttribute("selectedsubjectType", subjectType);
		model.addAttribute("subjectType", subjectType);
		String email=(String) session.getAttribute("email");
		
		Integer markValue;
		String markPurpose;
		Integer markWeight;
		HashSet<Object> pupilsMarks = new HashSet<Object>();
		pupilsMarks.clear();
		System.out.println(subjectType);
		System.out.println("-----------"+pupilsMarks.size());
		Integer numerNauczyciela = lessonRepo.findTeacher(pupilRepo.szukajId(email),subjectType);
	
		
		String teacherFirstName=teacherRepo.findFirstNameTeacher(numerNauczyciela);
		String teacherLastName= teacherRepo.findLastNameTeacher(numerNauczyciela);
	
		TeacherDTO teacher = new TeacherDTO(teacherFirstName,teacherLastName);
		model.addAttribute("teacherFirstName",teacher.getFirstName());
		model.addAttribute("teacherLastName",teacher.getLasName());
		Integer pupilId= pupilRepo.szukajId(email);
		System.out.println("pupil    "+pupilId);
		System.out.println("findSchollClassId    "+lessonRepo.findSchollClassId(pupilId));

		System.out.println("findLessonId    "+lessonRepo.findLessonId(lessonRepo.findSchollClassId(pupilId), subjectType));
		for (Object[] obj : lessonRepo.findValuesToMarkTable(pupilId, lessonRepo.findLessonId(lessonRepo.findSchollClassId(pupilId), subjectType)))
		{
		    markValue =   (int) obj[0];
		    markPurpose =  (String) obj[1];
		    markWeight =  (int) obj[2];

	    MarksDTO mark = new MarksDTO(markValue,markPurpose,markWeight);
		    pupilsMarks.add(mark);
		}
		System.out.println("-----------"+pupilsMarks.size());
		model.addAttribute("userMarks",pupilsMarks);
		return "checkmarks";

	}	   
}
