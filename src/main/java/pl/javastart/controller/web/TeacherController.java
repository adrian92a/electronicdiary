package pl.javastart.controller.web;

import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.javastart.DTO.MarksDTO;
import pl.javastart.DTO.PupilDTO;
import pl.javastart.Search.SearchOption;
import pl.javastart.Search.SearchOptionPupils;

import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.MarkRepository;
import pl.javastart.repository.PupilRepository;
import pl.javastart.service.TeacherService;

import javax.validation.Valid;


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
	public String getListOfPupilsToInsertMarks(@ModelAttribute("selectedOption") SearchOption selectedOption,											   Model model)
	{
		teacherService.inserMarksForm(model,selectedOption);
		model.addAttribute("item", "");
		TreeSet<PupilDTO> pupilList =teacherService.getListOfPupilsFromLesson(selectedOption.getOption(),model);
		model.addAttribute("pupilList",pupilList);
		model.addAttribute("option",selectedOption.getOption());
		return "insertmarks"; }

	@GetMapping("/insertOneMark")
	public String insertMarkHandler(@RequestParam("lessonId") Integer lessonId,
									@ModelAttribute("selectedOption") SearchOption selectedOption,
							 @RequestParam("pupilId") Integer pupilId,
							 @RequestParam("mark") Integer mark,
							 @RequestParam("description") String description,
							 @RequestParam("markWeight") Integer markWeight,
							Model model )
	{
		teacherService.inserMarksForm(model,selectedOption);
		 teacherService.insertMark(lessonId,pupilId,mark,description,markWeight);
		return "/insertmarks";
	}

	public Integer pupilID;
	public Integer lessonID;

	@GetMapping(value = "/insertmarksform")
	public String insertmarksformHandler( Model model,@ModelAttribute("selectedOption") SearchOption selectedOption)
	{
		teacherService.inserMarksForm(model,selectedOption);
		return "insertmarks";
	}

	@GetMapping("/checkMarksByTeacher")
	public String viemarksformHandler( Model model,@ModelAttribute("selectedOption") SearchOption selectedOption,
									  @ModelAttribute("selectedOptionPupil") SearchOptionPupils searchOptionPupils)
	{
		model.addAttribute("MarksDTO", new MarksDTO());
		teacherService.inserMarksForm(model,selectedOption);
		teacherService.selectPupilToViewMarks(model,selectedOption.getOption(),searchOptionPupils);
		return "checkMarksByTeacher";
	}


	@RequestMapping(value="/selectPupilToVieMarks", method = RequestMethod.GET)
	public String selectPupilToViewMarksHandler( Model model,
												  @ModelAttribute("selectedOption") SearchOption selectedOption,
												  @ModelAttribute(	"selectedOptionPupil") SearchOptionPupils selectedOptionPupil,
												@RequestParam("option") Integer selectedLesson
												)
	{

		Integer lessonId = selectedOption.getOption();
		teacherService.inserMarksForm(model,selectedOption);
		teacherService.selectPupilToViewMarks(model,lessonId,selectedOptionPupil);
		lessonID=selectedLesson;
		return "checkMarksByTeacher";
	}

	@GetMapping("/viewMarksTableToEdit")
	public String viewMarksTableToEditHandler( Model model,
											  @ModelAttribute("selectedOption") SearchOption selectedOption,
											  @ModelAttribute("selectedOptionPupil") SearchOptionPupils selectedOptionPupil,
														  @RequestParam("optionPupil") Integer selectedPupil)
	{
		teacherService.viewMarksTableToEdit(model,selectedOptionPupil);
		pupilID=selectedPupil;
		teacherService.inserMarksForm(model,selectedOption);
		teacherService.selectPupilToViewMarks(model,lessonID,selectedOptionPupil);
		return "checkMarksByTeacher";
	}
	@GetMapping("/deleteMark")
	public String deleteMarkHandler(Model model,
									@ModelAttribute("selectedOption") SearchOption selectedOption,
									@ModelAttribute("selectedOptionPupil") SearchOptionPupils selectedOptionPupil,
									@RequestParam("markId") Integer markId)
	{
		teacherService.inserMarksForm(model,selectedOption);
		teacherService.selectPupilToViewMarks(model,lessonID,selectedOptionPupil);
		markRepo.delete(markRepo.findMarkById(markId));
		teacherService.viewMarksTableToEdit(model,selectedOptionPupil);
		return "checkMarksByTeacher";
	}
	@GetMapping("/editMark")
	public String editMarkHandler( Model model,
								  @ModelAttribute("selectedOption") SearchOption selectedOption,
								  @ModelAttribute("selectedOptionPupil") SearchOptionPupils selectedOptionPupil,
								  @RequestParam("markId") Integer markId,
								  @RequestParam("markValue") Integer markValue,
								  @RequestParam("markPurpose") String markPurpose,
								  @RequestParam("markWeight") Integer markWeight)
	{
		teacherService.inserMarksForm(model,selectedOption);
		teacherService.selectPupilToViewMarks(model,lessonID,selectedOptionPupil);
		teacherService.editMark( model,markId,markValue,markPurpose,markWeight);
		teacherService.viewMarksTableToEdit(model,selectedOptionPupil);
		return "checkMarksByTeacher";
	}

		
}
