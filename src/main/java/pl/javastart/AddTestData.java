package pl.javastart;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import pl.javastart.model.Lesson;
import pl.javastart.model.Mark;
import pl.javastart.model.Pupil;
import pl.javastart.model.RegisterKey;
import pl.javastart.model.Role;
import pl.javastart.model.Schollclass;
import pl.javastart.model.Teacher;
import pl.javastart.model.User;
import pl.javastart.repository.LessonRepository;
import pl.javastart.repository.MarkRepository;
import pl.javastart.repository.PupilRepository;
import pl.javastart.repository.RegisterKeyRepository;
import pl.javastart.repository.RoleRepository;
import pl.javastart.repository.SchoolClassRepository;
import pl.javastart.repository.TeacherRepository;
import pl.javastart.repository.UserRepository;

@Component
public class AddTestData {


    @Autowired
    PupilRepository pupilRepo;

    @Autowired
    RegisterKeyRepository registerKeyRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TeacherRepository teacherRepo;

    @Autowired
    private SchoolClassRepository schoolClassRepo;

    @Autowired
    private LessonRepository lessonRepo;

    @Autowired
    private MarkRepository markRepository;
    private static DataSource datasource;

    @PostConstruct
    public void addTestData() {
        if (!roleRepo.existsById(1l)) {
        roleRepo.deleteAllInBatch();
        registerKeyRepo.deleteAllInBatch();
        userRepo.deleteAllInBatch();
        pupilRepo.deleteAllInBatch();
        schoolClassRepo.deleteAllInBatch();
        teacherRepo.deleteAllInBatch();

            Role role1 = new Role(1l, "nauczyciel");
            Role role2 = new Role(2l, "uczeń");

            roleRepo.save(role1);
            roleRepo.save(role2);

            RegisterKey registerKey1 = new RegisterKey("123", "Janusz", "Pędziwiatr", "1256231", null, null, false);
            RegisterKey registerKey2 = new RegisterKey("321", "Kuba", "Wojewódzki", "412412", 1, "B", false);
            RegisterKey registerKey3 = new RegisterKey("311", "Ferdynant", "Kiepski", "51251252", 1, "B", false);

            // 1- nauczyciel
            // 2 -uczeń


            registerKey1.setRole(role1);
            registerKey2.setRole(role2);
            registerKey3.setRole(role2);

            registerKeyRepo.save(registerKey1);
            registerKeyRepo.save(registerKey2);
            registerKeyRepo.save(registerKey3);

            User user1 = new User("janpedz@szkola.com", "tajne");
            User user2 = new User("kjanpedz@szkola.com", "bardzotajne");
            User user3 = new User("ferkiep@szkola.com", "hasloniedozgadniecia");

            user1.setRole(role1);
            user2.setRole(role2);
            user3.setRole(role2);

            userRepo.save(user1);
            userRepo.save(user2);
            userRepo.save(user3);

            Schollclass schollclass1 = new Schollclass(1, "A");
            Schollclass schollclass2 = new Schollclass(1, "B");
            Schollclass schollclass3 = new Schollclass(1, "C");

            Pupil pupil2 = new Pupil("Kuba", "Wojewódzki", "412412");
            Pupil pupil3 = new Pupil("Ferdynant", "Kiepski", "51251252");

            schoolClassRepo.save(schollclass1);
            schoolClassRepo.save(schollclass2);
            schoolClassRepo.save(schollclass3);

            pupil3.setUser(user3);
            pupil3.setSchollclass(schollclass1);
            pupilRepo.save(pupil3);


            pupil2.setUser(user2);
            pupil2.setSchollclass(schollclass1);
            pupilRepo.save(pupil2);


            Teacher teacher1 = new Teacher("Janusz", "Pędziwiatr", "1256231");
            teacher1.setUser(user1);
            teacherRepo.save(teacher1);


            Lesson matematyka1 = new Lesson();
            Lesson matematyka2 = new Lesson();
            Lesson matematyka3 = new Lesson();

            matematyka1.setTeacher(teacher1);
            matematyka2.setTeacher(teacher1);
            matematyka3.setTeacher(teacher1);


            matematyka1.setSchollclass(schollclass1);
            matematyka1.setSubjectName("matematyka");

            matematyka2.setSchollclass(schollclass2);
            matematyka2.setSubjectName("matematyka");

            matematyka3.setSchollclass(schollclass3);
            matematyka3.setSubjectName("matematyka");


            Mark mark1 = new Mark(5, 3, "sprawdzian", pupil2);
            Set<Mark> markSet = new HashSet<>();
            mark1.setLesson(matematyka1);
            markSet.add(mark1);

            lessonRepo.save(matematyka1);
            lessonRepo.save(matematyka2);
            lessonRepo.save(matematyka3);

            markRepository.save(mark1);

        }
    }
}

