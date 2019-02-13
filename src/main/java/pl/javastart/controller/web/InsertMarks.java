package pl.javastart.controller.web;
import java.util.List;
import java.util.TreeSet;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.javastart.model.ClassDTO;
import pl.javastart.model.Lesson;
import pl.javastart.model.Mark;
import pl.javastart.model.Pupil;
import pl.javastart.model.PupilDTO;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.MarkRepository;
import pl.javastart.repository.PupilRepository;

@Controller
public class InsertMarks {

	@Autowired
	private LessonRepository lessonRepo;
	@Autowired
	private MarkRepository markRepo;
	@Autowired
	private PupilRepository pupilRepo;
	@Autowired
	private SchollclassListController schollclassListController;

	@GetMapping(value ="/selectformget")
	public String selectform(HttpSession session, Model model) {
		List<ClassDTO> list = schollclassListController.getPupilsListFromSelectedSchollClass(session);
	    model.addAttribute("classes", list);
	    return "insertmarks";
	}
	@RequestMapping(value="/selectedClass", method = RequestMethod.POST)
	public String save(HttpSession session,@RequestParam("lessonId") Integer lessonId, Model model)
	{
		System.out.println(lessonId);
			List<ClassDTO> list = schollclassListController.getPupilsListFromSelectedSchollClass(session);
		    model.addAttribute("classes", list);
		    String email=(String) session.getAttribute("email");
		    Integer pupilId;
			String pupilFirstName;
			String pupilLastName;
			int index=0;
			TreeSet<Object> pupilList = new TreeSet<Object>();
		    for (Object[] obj : pupilRepo.findPupilListFromLessonId(lessonId))
			{
		    	index= index+1;
		    	pupilId =   (int) obj[0];
			    pupilFirstName =  (String) obj[1];
			    pupilLastName =  (String) obj[2];
				PupilDTO pupil = new PupilDTO(index,pupilId,pupilFirstName,pupilLastName,lessonId);
				pupilList.add(pupil);
			}
		    model.addAttribute("pupilList",pupilList);
		return "insertmarks";
	}
	@GetMapping("/insertOneMark")
	public String insertMark(HttpSession session,@RequestParam("lessonId") Integer lessonId,
							 @RequestParam("firstName") String firstName,
							 @RequestParam("pupilId") Integer pupilId,
							 @RequestParam("lastName") String lastName,
							 @RequestParam("mark") Integer mark,
							 @RequestParam("description") String description,
							 @RequestParam("markWeight") Integer markWeight,
							 Model model)
	{
		Lesson lesson;
		lesson=lessonRepo.getOne(lessonId);
		Pupil pupil;
		pupil = pupilRepo.getOne(pupilId);
		Mark insertMark= new Mark(mark,markWeight,description);

		insertMark.setLesson(lesson);
		insertMark.setPupil(pupil);
		markRepo.save(insertMark);
		model.addAttribute("message","Pomyślnie wstawiono ocene uczniowi: "+ pupil.getFirstName()+" "+pupil.getLastName());

		return "/insertmarks";
	}
}

	
