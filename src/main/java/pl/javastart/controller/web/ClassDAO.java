package pl.javastart.controller.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.javastart.model.ClassDTO;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.TeacherRepository;
import pl.javastart.repository.UserRepository;
 


 
@Repository
public class ClassDAO {
 
	@Autowired
	private AccountController accountcontrol;
	
	

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private LessonRepository lessonRepo;

	@Autowired
	TeacherRepository teacherRepo;
	
	
//
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
//	return classLetter;
//}
	
  
    public String userEmail(HttpSession session)
    {
    	String email=(String) session.getAttribute("email");
		return email;
  	
    }
   
    
    private List<ClassDTO> list(HttpSession session) 
 {
    	 List<ClassDTO> teacherClasses = new ArrayList<ClassDTO>();
    	String email=(String) session.getAttribute("email");
    
    	Integer lessonId;
    Integer classId;
   	 Integer classNumber;
   	 String classLetter;
   	 String subjectName;
   
    	for(Object[] obj : lessonRepo.findTeacherClass(teacherRepo.findTeacherID(userRepo.findUserByEmail(email)))) 
    	{
    		lessonId =(Integer) obj[4];
    		classId =   (Integer) obj[0];
    		classNumber =  (Integer) obj[1];
    		classLetter = (String) obj[2];
    		subjectName =(String) obj[3];
    		
    		
    		ClassDTO cl = new ClassDTO(classId,classNumber,classLetter,subjectName,lessonId); 
    		teacherClasses.add(cl);
    	}
   
		return teacherClasses;
 }
 

    public List<ClassDTO> getCountries(HttpSession session) {
        return list(session) ;
    }
}