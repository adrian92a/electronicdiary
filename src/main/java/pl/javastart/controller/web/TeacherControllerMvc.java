package pl.javastart.controller.web;

import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.javastart.model.MarksDTO;
import pl.javastart.model.Schollclass;
import pl.javastart.model.TeacherDTO;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.MarkRepository;
import pl.javastart.repository.PupilRepository;
import pl.javastart.repository.TeacherRepository;

public class TeacherControllerMvc {
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
	

//	@RequestMapping(value = { "/insertmarks1" }, method = RequestMethod.GET)
//	public String selectOptionExample1Page(Model model,HttpSession session) {
//	
//		String email=(String) session.getAttribute("email");
//		lessonRepo.findTeacherClass(teacherRepo.findTeacherID(email));
//		HashSet<Object> classTeacher = new HashSet<Object>(); 
//		
//		model.addAttribute("classTeacher", classTeacher);
//		
//	 
//	 
//	    return "index";  
//   
//	}

}	   

