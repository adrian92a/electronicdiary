package pl.javastart.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.javastart.DTO.MarksDTO;
import pl.javastart.Search.SearchLessonList;
import pl.javastart.DTO.TeacherDTO;
import pl.javastart.model.Lesson;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.MarkRepository;
import pl.javastart.repository.PupilRepository;
import pl.javastart.repository.TeacherRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class PupilService {

    private TeacherRepository teacherRepo;
    private PupilRepository pupilRepo;
    private LessonRepository lessonRepo;
    private MarkRepository markRepo;


    public PupilService(TeacherRepository teacherRepo, PupilRepository pupilRepo, LessonRepository lessonRepo, MarkRepository markRepo) {
        this.teacherRepo = teacherRepo;
        this.pupilRepo = pupilRepo;
        this.lessonRepo = lessonRepo;
        this.markRepo = markRepo;
    }

    public String email(HttpSession session)
    {
        return (String) session.getAttribute("email");
    }


    public void showMarks(HttpSession session, String subjectType,
                                      Model model)
    {
        model.addAttribute("selectedsubjectType", subjectType);
        model.addAttribute("subjectType", subjectType);
        String email=(String) session.getAttribute("email");
        Integer markValue;
        String markPurpose;
        Integer markWeight;
        HashSet<Object> userMarks = new HashSet<Object>();
        userMarks.clear();

        Integer numerNauczyciela = lessonRepo.findTeacher(pupilRepo.szukajId(email),subjectType);
        String teacherFirstName=teacherRepo.findFirstNameTeacher(numerNauczyciela);
        String teacherLastName= teacherRepo.findLastNameTeacher(numerNauczyciela);

        TeacherDTO teacher = new TeacherDTO(teacherFirstName,teacherLastName);
        model.addAttribute("teacherFirstName",teacher.getFirstName());
        model.addAttribute("teacherLastName",teacher.getLasName());
        Integer pupilId= pupilRepo.szukajId(email);

        System.out.println("findLessonId    "+lessonRepo.findLessonId(lessonRepo.findSchollClassId(pupilId), subjectType));
        for (Object[] obj : lessonRepo.findValuesToMarkTable(pupilId, lessonRepo.findLessonId(lessonRepo.findSchollClassId(pupilId), subjectType)))
        {
            markValue =   (int) obj[0];
            markPurpose =  (String) obj[1];
            markWeight =  (int) obj[2];

            MarksDTO mark = new MarksDTO(markValue,markPurpose,markWeight);
            userMarks.add(mark);
        }
        if(userMarks.isEmpty())
        {
            model.addAttribute("emptyList","Z wybranego przedmiotu nie masz jeszcze zadnych ocen");
        }
        model.addAttribute("userMarks",userMarks);


    }
    public void showListOfSubjects(HttpSession session, Model model)
    {
        List<String> lessonList= new ArrayList<>();
        List<Lesson> pupilLessonList = lessonRepo.findAllBySchollclass_Id(pupilRepo.pupilSchoolclassId(pupilRepo.szukajId(session.getAttribute("email").toString())));
        List<SearchLessonList> searchLessonLists = new ArrayList<>();
        for(Lesson l:pupilLessonList)
        {
            SearchLessonList searchLessonList=new SearchLessonList();
            searchLessonList.setLessonList(l.getId());
            searchLessonList.setOptionLessonName(l.getSubjectName());
            searchLessonLists.add(searchLessonList);
            System.out.println(searchLessonList.getLessonList());
            System.out.println(searchLessonList.getOptionLessonName());
        }
        model.addAttribute("lessonList",searchLessonLists);

    }

}
