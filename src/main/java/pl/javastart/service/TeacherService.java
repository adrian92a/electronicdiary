package pl.javastart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.DTO.ClassDTO;
import pl.javastart.DTO.MarksDTO;
import pl.javastart.DTO.PupilDTO;
import pl.javastart.Search.SearchOption;
import pl.javastart.Search.SearchOptionPupils;
import pl.javastart.controller.web.UserController;
import pl.javastart.model.Lesson;
import pl.javastart.model.Mark;
import pl.javastart.model.Pupil;
import pl.javastart.repository.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Service
public class TeacherService {

    private MarkRepository markRepo;
    private PupilRepository pupilRepo;
    private UserController accountcontrol;
    private UserRepository userRepo;
    private LessonRepository lessonRepo;
    private TeacherRepository teacherRepo;
    @Autowired
    private  UserContextService userContextService;
    @Autowired
    private TeacherService teacherService;

    public TeacherService(MarkRepository markRepo, PupilRepository pupilRepo, UserController accountcontrol, UserRepository userRepo, LessonRepository lessonRepo, TeacherRepository teacherRepo, UserContextService userContextService) {

        this.markRepo = markRepo;
        this.pupilRepo = pupilRepo;
        this.accountcontrol = accountcontrol;
        this.userRepo = userRepo;
        this.lessonRepo = lessonRepo;
        this.teacherRepo = teacherRepo;
        this.userContextService = userContextService;

    }
    public List<ClassDTO> lessonList()
    {
        List<ClassDTO> teacherClasses = new ArrayList<ClassDTO>();
        String email= userContextService.getLoggedAs();

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

    public TreeSet<PupilDTO> getListOfPupilsFromLesson( Integer lessonId, Model model)
    {
                String email=(String) userContextService.getLoggedAs();
                Integer pupilId;
                String pupilFirstName;
                String pupilLastName;
                int index=0;
                TreeSet<PupilDTO> pupilList = new TreeSet<PupilDTO>();

                for (Object[] obj : pupilRepo.findPupilListFromLessonId(lessonId))
                {
                    index= index+1;
                    pupilId =   (int) obj[0];
                    pupilFirstName =  (String) obj[1];
                    pupilLastName =  (String) obj[2];
                    PupilDTO pupil = new PupilDTO(index,pupilId,pupilFirstName,pupilLastName,lessonId);
                    pupilList.add(pupil);
                }
               return pupilList;
        }

    public void insertMark(Integer lessonId, Integer pupilId, Integer mark, String description, Integer markWeight,
                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate markDate)
    {
        Lesson lesson;
        lesson=lessonRepo.getOne(lessonId);
        Pupil pupil;
        pupil = pupilRepo.getOne(pupilId);
        Mark insertMark= new Mark(mark,markWeight,description,pupil,markDate);
        System.out.println("mark============="+mark);
        insertMark.setLesson(lesson);
        markRepo.save(insertMark);

    }

    public void inserMarksForm( Model model, SearchOption selectedOption) {
        List<SearchOption> searchOptions = new ArrayList<>();
        for (ClassDTO x : teacherService.lessonList()) {
            SearchOption searchOption = new SearchOption();
            searchOption.setOption(x.getLessonId());
            searchOption.setOptionName(x.getClassNumber().toString() + x.getClassLetter().toString() + " " + x.getSubjectName().toString());
            searchOptions.add(searchOption);
        }
        model.addAttribute("searchOptions", searchOptions);

    }

    public void selectPupilToViewMarks( Model model, Integer lessonId, SearchOptionPupils selectedOptionPupil) {
        TreeSet<PupilDTO> pupilList= teacherService.getListOfPupilsFromLesson(lessonId,model);
        List<SearchOptionPupils> searchOptionPupils = new ArrayList<>();

        for (PupilDTO x : pupilList) {
            SearchOptionPupils searchOptionPupil = new SearchOptionPupils();
            searchOptionPupil.setOptionPupil(x.getPupilId());
            searchOptionPupil.setOptionPupilName(x.getFirstName()+" "+x.getLastName());
            System.out.println(searchOptionPupil.getOptionPupil());
            System.out.println(searchOptionPupil.getOptionPupilName());
            searchOptionPupils.add(searchOptionPupil);
        }
        model.addAttribute("searchOptionsPupil", searchOptionPupils);

    }




    public List<MarksDTO> viewMarksTableToEdit(Model model, SearchOptionPupils selectedOptionPupil)
    {
        System.out.println(selectedOptionPupil.getOptionPupil());
        List<Mark> marks= markRepo.findAllByPupil_Id(selectedOptionPupil.getOptionPupil());
        List<MarksDTO> markList= new ArrayList<>();
        int index=0;
        for(Mark m:marks)
        {
            index= index+1;
            MarksDTO marksDTO = new MarksDTO(m.getId(),m.getMarkValue(),m.getMarkPurpose(),m.getMarkWeight(),m.getMarkDate(),index);
            markList.add(marksDTO);
        }
        if(markList.isEmpty())
        {
            model.addAttribute("emptyListMessage","Wybrany czen nie ma zadnych ocen");
        }

        model.addAttribute("markList",markList);
        return markList;
    }

    public List<MarksDTO> viewMarksTableToEditAfterEdit(Model model, Integer pupilId)
    {

        List<Mark> marks= markRepo.findAllByPupil_Id(pupilId);
        List<MarksDTO> markList= new ArrayList<>();
        int index=0;
        for(Mark m:marks)
        {
            index= index+1;
            MarksDTO marksDTO = new MarksDTO(m.getId(),m.getMarkValue(),m.getMarkPurpose(),m.getMarkWeight(),m.getMarkDate(),index);
            markList.add(marksDTO);
        }
        if(markList.isEmpty())
        {
            model.addAttribute("emptyListMessage","Wybrany czen nie ma zadnych ocen");
        }

        model.addAttribute("markList",markList);
        return markList;
    }




    public void editMark(Model model,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate markDate ,Integer markId, Integer markValue,String markPurpose, Integer markWeight) {
        if (markValue < 7 && markValue > 0 && markWeight < 11 && markWeight > 0) {
            Mark mark = markRepo.findMarkById(markId);
            mark.setMarkValue(markValue);
            mark.setMarkPurpose(markPurpose);
            mark.setMarkWeight(markWeight);
            mark.setMarkDate(markDate);
            markRepo.save(mark);
        }
        else {
            model.addAttribute("editMarksError", "Zostały wprowadzone niepoprawne wartości, wartośc oceny musi być w przedziale od 1 do 6, natomiast waga oceny od 1 do 10");
        }
        }
    }


