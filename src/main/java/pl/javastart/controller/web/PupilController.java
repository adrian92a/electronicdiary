package pl.javastart.controller.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.Search.SearchLessonList;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.MarkRepository;
import pl.javastart.repository.PupilRepository;
import pl.javastart.repository.TeacherRepository;
import pl.javastart.service.PupilService;
import javax.servlet.http.HttpSession;


@Controller
public class PupilController {
	private static final int Mark = 0;
	private PupilService pupilService;
	private TeacherRepository teacherRepo;
	private PupilRepository pupilRepo;
	private LessonRepository lessonRepo;
	private MarkRepository markRepo;

	public PupilController(PupilService pupilService, TeacherRepository teacherRepo, PupilRepository pupilRepo, LessonRepository lessonRepo, MarkRepository markRepo) {
		this.pupilService = pupilService;
		this.teacherRepo = teacherRepo;
		this.pupilRepo = pupilRepo;
		this.lessonRepo = lessonRepo;
		this.markRepo = markRepo;
	}

	public String lessonName;
	@GetMapping(value = "/checkmarks")
	public String showListOfSubjectsHandler(HttpSession session,
											Model model,
											@ModelAttribute("selectedLeson") SearchLessonList selectedLeson)
	{
		pupilService.showListOfSubjects(session,model);
		return "checkmarks";
	}

	@PostMapping(value = "/showMarks")
	public String showMarksHandler(HttpSession session,
								   Model model,
								   @ModelAttribute("selectedLeson") SearchLessonList selectedLeson,
								   @RequestParam("lessonList") Integer lessonId)
		{
			lessonName=lessonRepo.lessonName(lessonId);
			pupilService.showListOfSubjects(session,model);
			pupilService.showMarks(session,lessonName,model);
			return "checkmarks";

		}
}
