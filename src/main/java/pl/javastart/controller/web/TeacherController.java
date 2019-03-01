package pl.javastart.controller.web;

import java.util.TreeSet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.javastart.DTO.PupilDTO;
import pl.javastart.Search.SearchOption;
import pl.javastart.Search.SearchOptionPupils;

import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.MarkRepository;
import pl.javastart.repository.PupilRepository;
import pl.javastart.service.TeacherService;


@Controller
public class TeacherController {
	private LessonRepository lessonRepo;
	private MarkRepository markRepo;
	private TeacherService teacherService;
	private PupilRepository pupilRepo;
	public TeacherController(LessonRepository lessonRepo, MarkRepository markRepo, TeacherService teacherService, PupilRepository pupilRepo) {
		this.lessonRepo = lessonRepo;
		this.markRepo = markRepo;
		this.teacherService = teacherService;
		this.pupilRepo = pupilRepo;
	}




	@RequestMapping(value="/selectedClassToInsertMarks", method = RequestMethod.POST)
	public String getListOfPupilsToInsertMarks(HttpSession session,@ModelAttribute("selectedOption") SearchOption selectedOption,											   Model model)
	{
		teacherService.inserMarksForm(session,model,selectedOption);
		model.addAttribute("item", "");
		TreeSet<PupilDTO> pupilList =teacherService.getListOfPupilsFromLesson(session,selectedOption.getOption(),model);
		model.addAttribute("pupilList",pupilList);
		model.addAttribute("option",selectedOption.getOption());
		return "insertmarks"; }

	@GetMapping("/insertOneMark")
	public String insertMarkHandler(HttpSession session,@RequestParam("lessonId") Integer lessonId,
									@ModelAttribute("selectedOption") SearchOption selectedOption,
							 @RequestParam("firstName") String firstName,
							 @RequestParam("pupilId") Integer pupilId,
							 @RequestParam("lastName") String lastName,
							 @RequestParam("mark") Integer mark,
							 @RequestParam("description") String description,
							 @RequestParam("markWeight") Integer markWeight,
							Model model )
	{
		teacherService.inserMarksForm(session,model,selectedOption);
		 teacherService.insertMark(session,lessonId,firstName,pupilId,lastName,mark,description,markWeight,model);
		return "/insertmarks";
	}

	public Integer pupilID;
	public Integer lessonID;

	@GetMapping(value = "/insertmarksform")
	public String insertmarksformHandler(HttpSession session, Model model,@ModelAttribute("selectedOption") SearchOption selectedOption)
	{
		teacherService.inserMarksForm(session,model,selectedOption);
		return "insertmarks";
	}

	@GetMapping("/viewmarksteacher")
	public String viemarksformHandler(HttpSession session, Model model,@ModelAttribute("selectedOption") SearchOption selectedOption,
									  @ModelAttribute("selectedOptionPupil") SearchOptionPupils searchOptionPupils)
	{
		teacherService.inserMarksForm(session,model,selectedOption);
		teacherService.selectPupilToViewMarks(session,model,selectedOption.getOption(),searchOptionPupils);
		return "chechkmarksbyteacher";
	}


	@RequestMapping(value="/selectPupilToVieMarks", method = RequestMethod.POST)
	public String selectPupilToViewMarksHandler(HttpSession session, Model model,
												  @ModelAttribute("selectedOption") SearchOption selectedOption,
												  @ModelAttribute("selectedOptionPupil") SearchOptionPupils selectedOptionPupil,
												@RequestParam("option") Integer selectedLesson
												)
	{

		Integer lessonId = selectedOption.getOption();
		teacherService.inserMarksForm(session,model,selectedOption);
		teacherService.selectPupilToViewMarks(session,model,lessonId,selectedOptionPupil);
		lessonID=selectedLesson;
		return "chechkmarksbyteacher";
	}

	@PostMapping("/viewMarksTableToEdit")
	public String viewMarksTableToEditHandler(HttpSession session, Model model,
											  @ModelAttribute("selectedOption") SearchOption selectedOption,
											  @ModelAttribute("selectedOptionPupil") SearchOptionPupils selectedOptionPupil,
														  @RequestParam("optionPupil") Integer selectedPupil)
	{
		teacherService.viewMarksTableToEdit(session,model,selectedOption,selectedOptionPupil);
		pupilID=selectedPupil;
		teacherService.inserMarksForm(session,model,selectedOption);
		teacherService.selectPupilToViewMarks(session,model,lessonID,selectedOptionPupil);
		return "chechkmarksbyteacher";
	}
	@PostMapping("/deleteMark")
	public String deleteMarkHandler(HttpSession session, Model model,
									@ModelAttribute("selectedOption") SearchOption selectedOption,
									@ModelAttribute("selectedOptionPupil") SearchOptionPupils selectedOptionPupil,
									@RequestParam("markId") Integer markId)
	{
		teacherService.inserMarksForm(session,model,selectedOption);
		teacherService.selectPupilToViewMarks(session,model,lessonID,selectedOptionPupil);
		markRepo.delete(markRepo.findMarkById(markId));
		teacherService.viewMarksTableToEdit(session,model,selectedOption,selectedOptionPupil);
		return "chechkmarksbyteacher";
	}
	@PostMapping("/editMark")
	public String editMarkHandler(HttpSession session, Model model,
									@ModelAttribute("selectedOption") SearchOption selectedOption,
									@ModelAttribute("selectedOptionPupil") SearchOptionPupils selectedOptionPupil,
									@RequestParam("markId") Integer markId,
								  @RequestParam("markValue") Integer markValue,
								  @RequestParam("markPurpose") String markPurpose,
								  @RequestParam("markWeight") Integer markWeight)
	{
		teacherService.inserMarksForm(session,model,selectedOption);
		teacherService.selectPupilToViewMarks(session,model,lessonID,selectedOptionPupil);
		teacherService.editMark(markId,markValue,markPurpose,markWeight);
		teacherService.viewMarksTableToEdit(session,model,selectedOption,selectedOptionPupil);
		return "chechkmarksbyteacher";
	}

		
}
