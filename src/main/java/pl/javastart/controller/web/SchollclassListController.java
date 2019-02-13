package pl.javastart.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.javastart.model.ClassDTO;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.TeacherRepository;
import pl.javastart.repository.UserRepository;
@Repository
public class SchollclassListController {
 
	@Autowired
	private AccountController accountcontrol;
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private LessonRepository lessonRepo;

	@Autowired
	TeacherRepository teacherRepo;

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

    		classId =   (Integer) obj[0];
    		classNumber =  (Integer) obj[1];
    		classLetter = (String) obj[2];
    		subjectName =(String) obj[3];
			lessonId =(Integer) obj[4];
    		ClassDTO cl = new ClassDTO(classId,classNumber,classLetter,subjectName,lessonId); 
    		teacherClasses.add(cl);
    	}
		return teacherClasses;
 }
    public List<ClassDTO> getPupilsListFromSelectedSchollClass(HttpSession session) {
        return list(session) ;
    }
}