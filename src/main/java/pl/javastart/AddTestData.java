package pl.javastart;



import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import pl.javastart.model.Lesson;

import pl.javastart.model.Pupil;

import pl.javastart.model.RegisterKey.RegisterKey;

import pl.javastart.model.RegisterKey.RoleKey;
import pl.javastart.model.Schollclass;
import pl.javastart.model.Teacher;

import pl.javastart.model.User.Role;
import pl.javastart.model.User.User;
import pl.javastart.repository.*;

@Component
public class AddTestData {

    @Autowired
    RoleKeyRepository roleKeyRepo;

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

    private PasswordEncoder passwordEncoder;

    public AddTestData(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void addTestData() {
        if (!roleRepo.existsById(1))
        {
            roleRepo.deleteAllInBatch();
            registerKeyRepo.deleteAllInBatch();
            userRepo.deleteAllInBatch();
            pupilRepo.deleteAllInBatch();
            schoolClassRepo.deleteAllInBatch();
            teacherRepo.deleteAllInBatch();



            RegisterKey registerKey1 = new RegisterKey("12993", "Janusz", "Pędziwiatr", "99111664155", null, null, true);
            RegisterKey registerKey2 = new RegisterKey("32991", "Kuba", "Wojewódzki", "98010871488", 1, "B", true);
            RegisterKey registerKey3 = new RegisterKey("31991", "Ferdynant", "Kiepski", "99100992443", 1, "B", true);
            RegisterKey registerKey4 = new RegisterKey("339952", "Eugeniusz ", "Jabłoński", "99111164235", null, null, true);
            RegisterKey registerKey5 = new RegisterKey("94915", "Dobrogost ", "Czerwinski", "97040499916", null, null, true);
            RegisterKey registerKey6 = new RegisterKey("1129246598", "Jadwiga ", "Szczepańska", "97091337234", null, null, true);
            RegisterKey registerKey7 = new RegisterKey("404025106", "Bartosz  ", "Szymański", "98040859742", null, null, true);
            RegisterKey registerKey8 = new RegisterKey("1097798051", "Mieszko", "Zieliński", "97080597991", null, null, true);
            RegisterKey registerKey9 = new RegisterKey("171537522", "Jerzy", "Lewandowski", "98073138548", null, null, true);
            RegisterKey registerKey10 = new RegisterKey("2056590322", "Milan", "Wiśniewski", "97080597991", 1, "A", true);
            RegisterKey registerKey11 = new RegisterKey("459928445", "Kinga", "Wójcik", "98073138548", 1, "A", true);
            RegisterKey registerKey12 = new RegisterKey("1744992402", "Nataniel", "Kaczmarek", "97041333648", 1, "C", true);
            RegisterKey registerKey13 = new RegisterKey("340834680", "Marek", "Krawczyk", "98040859742", 1, "C", true);
            RegisterKey registerKey14 = new RegisterKey("1022991820", "Magda", "Piotrowska", "97091337234", 2, "A", true);
            RegisterKey registerKey15 = new RegisterKey("623045951", "Adela", "Kwiatkowska", "98070126133", 2, "A", true);
            RegisterKey registerKey16 = new RegisterKey("89663323", "Genowefa", "Grabowska", "98040758577", 2, "B", true);
            RegisterKey registerKey17 = new RegisterKey("931057900", "Gustaw", "Kozłowski", "98111981343", 2, "B", true);
            RegisterKey registerKey18 = new RegisterKey("998988752", "Danuta", "Wojciechowska", "99012259544", 2, "A", true);
            RegisterKey registerKey19 = new RegisterKey("1526700115", "Ryszard", "Mazur", "98091899359", 2, "A", true);
            RegisterKey registerKey20 = new RegisterKey("2093950231", "Felicja", "Dąbrowska", "98030521484", 3, "B", true);
            RegisterKey registerKey21 = new RegisterKey("2273829826", "Aleks", "Nowak", "99051725411", 3, "B", true);
            RegisterKey registerKey22 = new RegisterKey("1886597183", "Ida", "Kowalska", "99071789156", 3, "C", true);
            RegisterKey registerKey23 = new RegisterKey("86123580", "Dorian", "Chełmoński", "99010776483", 3, "C", true);

            RegisterKey notUsedRegisterKey24 = new RegisterKey("1", "Kamil", "Cieszyński", "93011075459", 1, "A", false);
            RegisterKey notUsedRegisterKey25 = new RegisterKey("2", "Natan", "Ostrowski", "92021146612", 1, "B", false);
            RegisterKey notUsedRegisterKey26 = new RegisterKey("3", "Dagmara", "Chałupka", "91041455771", 1, "C", false);
            RegisterKey notUsedRegisterKey27 = new RegisterKey("4", "Piotr", "Duda", "93072534128", null, null, false);

            registerKeyRepo.save(registerKey1);
            registerKeyRepo.save(registerKey2);
            registerKeyRepo.save(registerKey3);
            registerKeyRepo.save(registerKey4);
            registerKeyRepo.save(registerKey5);
            registerKeyRepo.save(registerKey6);
            registerKeyRepo.save(registerKey7);
            registerKeyRepo.save(registerKey8);
            registerKeyRepo.save(registerKey9);
            registerKeyRepo.save(registerKey10);
            registerKeyRepo.save(registerKey11);
            registerKeyRepo.save(registerKey12);
            registerKeyRepo.save(registerKey13);
            registerKeyRepo.save(registerKey14);
            registerKeyRepo.save(registerKey15);
            registerKeyRepo.save(registerKey16);
            registerKeyRepo.save(registerKey17);
            registerKeyRepo.save(registerKey18);
            registerKeyRepo.save(registerKey19);
            registerKeyRepo.save(registerKey20);
            registerKeyRepo.save(registerKey21);
            registerKeyRepo.save(registerKey22);
            registerKeyRepo.save(registerKey23);
            registerKeyRepo.save(notUsedRegisterKey24);
            registerKeyRepo.save(notUsedRegisterKey25);
            registerKeyRepo.save(notUsedRegisterKey26);
            registerKeyRepo.save(notUsedRegisterKey27);




            // 1- nauczyciel
            // 2 -uczeń
//9-4 nauczyciele
            RoleKey roleKey1 = new RoleKey("ROLE_TEACHER",registerKey1);
            RoleKey roleKey2 = new RoleKey("ROLE_PUPIL",registerKey2);
            RoleKey roleKey3 = new RoleKey("ROLE_PUPIL",registerKey3);
            RoleKey roleKey4= new RoleKey("ROLE_TEACHER",registerKey4);
            RoleKey roleKey5 = new RoleKey("ROLE_TEACHER",registerKey5);
            RoleKey roleKey6 = new RoleKey("ROLE_TEACHER",registerKey6);
            RoleKey roleKey7 = new RoleKey("ROLE_TEACHER",registerKey7);
            RoleKey roleKey8 = new RoleKey("ROLE_TEACHER",registerKey8);
            RoleKey roleKey9 = new RoleKey("ROLE_TEACHER",registerKey9);
            RoleKey roleKey10 = new RoleKey("ROLE_PUPIL",registerKey10);
            RoleKey roleKey11 = new RoleKey("ROLE_PUPIL",registerKey11);
            RoleKey roleKey12 = new RoleKey("ROLE_PUPIL",registerKey12);
            RoleKey roleKey13 = new RoleKey("ROLE_PUPIL",registerKey13);
            RoleKey roleKey14 = new RoleKey("ROLE_PUPIL",registerKey14);
            RoleKey roleKey15 = new RoleKey("ROLE_PUPIL",registerKey15);
            RoleKey roleKey16 = new RoleKey("ROLE_PUPIL",registerKey16);
            RoleKey roleKey17 = new RoleKey("ROLE_PUPIL",registerKey17);
            RoleKey roleKey18 = new RoleKey("ROLE_PUPIL",registerKey18);
            RoleKey roleKey19 = new RoleKey("ROLE_PUPIL",registerKey19);
            RoleKey roleKey20 = new RoleKey("ROLE_PUPIL",registerKey20);
            RoleKey roleKey21 = new RoleKey("ROLE_PUPIL",registerKey21);
            RoleKey roleKey22 = new RoleKey("ROLE_PUPIL",registerKey22);
            RoleKey roleKey23 = new RoleKey("ROLE_PUPIL",registerKey23);
            RoleKey roleKey24 = new RoleKey("ROLE_PUPIL",notUsedRegisterKey24);
            RoleKey roleKey25 = new RoleKey("ROLE_PUPIL",notUsedRegisterKey25);
            RoleKey roleKey26 = new RoleKey("ROLE_PUPIL",notUsedRegisterKey26);
            RoleKey roleKey27 = new RoleKey("ROLE_TEACHER",notUsedRegisterKey27);

            roleKeyRepo.save(roleKey1);
            roleKeyRepo.save(roleKey2);
            roleKeyRepo.save(roleKey3);
            roleKeyRepo.save(roleKey4);
            roleKeyRepo.save(roleKey5);
            roleKeyRepo.save(roleKey6);
            roleKeyRepo.save(roleKey7);
            roleKeyRepo.save(roleKey8);
            roleKeyRepo.save(roleKey9);
            roleKeyRepo.save(roleKey10);
            roleKeyRepo.save(roleKey11);
            roleKeyRepo.save(roleKey12);
            roleKeyRepo.save(roleKey13);
            roleKeyRepo.save(roleKey14);
            roleKeyRepo.save(roleKey15);
            roleKeyRepo.save(roleKey16);
            roleKeyRepo.save(roleKey17);
            roleKeyRepo.save(roleKey18);
            roleKeyRepo.save(roleKey19);
            roleKeyRepo.save(roleKey20);
            roleKeyRepo.save(roleKey21);
            roleKeyRepo.save(roleKey22);
            roleKeyRepo.save(roleKey23);
            roleKeyRepo.save(roleKey24);
            roleKeyRepo.save(roleKey25);
            roleKeyRepo.save(roleKey26);
            roleKeyRepo.save(roleKey27);

            User user1 = new
                    User("janpedz@szkola.com",
                    passwordEncoder.
                            encode(
                                    "hasloniedozgadniecia"));
            User user2 = new User("kjanpedz@szkola.com",  passwordEncoder.encode("hasloniedozgadniecia"));
            User user3 = new User("ferkiep@szkola.com", passwordEncoder.encode("hasloniedozgadniecia"));
            User user4 = new User("eugjab@szkola.com",  passwordEncoder.encode("hasloniedozgadniecia"));
            User user5 = new User("dobczer@szkola.com",  passwordEncoder.encode("hasloniedozgadniecia"));
            User user6 = new User("jadszcz@szkola.com",  passwordEncoder.encode("hasloniedozgadniecia"));
            User user7 = new User("bar@szkola.com",  passwordEncoder.encode("hasloniedozgadniecia"));
            User user8 = new User("miesz@szkola.com",  passwordEncoder.encode("hasloniedozgadniecia"));
            User user9 = new User("jerz@szkola.com",  passwordEncoder.encode("hasloniedozgadniecia"));
            User user10 = new User("mil@szkola.com",  passwordEncoder.encode("hasloniedozgadniecia"));
            User user11 = new User("kinga@szkola.com",  passwordEncoder.encode("hasloniedozgadniecia"));
            User user12 = new User("natan@szkola.com",  passwordEncoder.encode("hasloniedozgadniecia"));
            User user13 = new User("mark@szkola.com",  passwordEncoder.encode("hasloniedozgadniecia"));
            User user14 = new User("magd@szkola.com", passwordEncoder.encode("hasloniedozgadniecia"));
            User user15 = new User("ade@szkola.com", passwordEncoder.encode("hasloniedozgadniecia"));
            User user16 = new User("geno@szkola.com", passwordEncoder.encode("hasloniedozgadniecia"));
            User user17 = new User("gusd@szkola.com", passwordEncoder.encode("hasloniedozgadniecia"));
            User user18 = new User("danutt@szkola.com", passwordEncoder.encode("hasloniedozgadniecia"));
            User user19 = new User("rys@szkola.com", passwordEncoder.encode("hasloniedozgadniecia"));
            User user20 = new User("felii@szkola.com", passwordEncoder.encode("hasloniedozgadniecia"));
            User user21 = new User("aleeks@szkola.com", passwordEncoder.encode("hasloniedozgadniecia"));
            User user22 = new User("idda@szkola.com", passwordEncoder.encode("hasloniedozgadniecia"));
            User user23 = new User("dorr@szkola.com", passwordEncoder.encode("hasloniedozgadniecia"));
//9-4 nauczyciele





            Role roleTeacher = new Role("ROLE_TEACHER");
            Role rolePupil = new Role("ROLE_PUPIL");

//
            roleRepo.save(roleTeacher);
            roleRepo.save(rolePupil);



            user1.getRoles().add(roleTeacher);
            user2.getRoles().add(rolePupil);
            user3.getRoles().add(rolePupil);
            user4.getRoles().add(roleTeacher);
            user5.getRoles().add(roleTeacher);
            user6.getRoles().add(roleTeacher);
            user7.getRoles().add(roleTeacher);
            user8.getRoles().add(roleTeacher);
            user9.getRoles().add(roleTeacher);
            user10.getRoles().add(rolePupil);
            user11.getRoles().add(rolePupil);
            user12.getRoles().add(rolePupil);
            user13.getRoles().add(rolePupil);
            user14.getRoles().add(rolePupil);
            user15.getRoles().add(rolePupil);
            user16.getRoles().add(rolePupil);
            user17.getRoles().add(rolePupil);
            user18.getRoles().add(rolePupil);
            user19.getRoles().add(rolePupil);
            user20.getRoles().add(rolePupil);
            user21.getRoles().add(rolePupil);
            user22.getRoles().add(rolePupil);
            user23.getRoles().add(rolePupil);

            roleTeacher.getUsers().add(user1);
            roleTeacher.getUsers().add(user4);
            roleTeacher.getUsers().add(user5);
            roleTeacher.getUsers().add(user6);
            roleTeacher.getUsers().add(user7);
            roleTeacher.getUsers().add(user8);
            roleTeacher.getUsers().add(user9);

            rolePupil.getUsers().add(user2);
            rolePupil.getUsers().add(user3);
            rolePupil.getUsers().add(user10);
            rolePupil.getUsers().add(user11);
            rolePupil.getUsers().add(user12);
            rolePupil.getUsers().add(user13);
            rolePupil.getUsers().add(user14);
            rolePupil.getUsers().add(user15);
            rolePupil.getUsers().add(user16);
            rolePupil.getUsers().add(user17);
            rolePupil.getUsers().add(user18);
            rolePupil.getUsers().add(user19);
            rolePupil.getUsers().add(user20);
            rolePupil.getUsers().add(user21);
            rolePupil.getUsers().add(user22);
            rolePupil.getUsers().add(user23);

            userRepo.save(user1);
            userRepo.save(user2);
            userRepo.save(user3);
            userRepo.save(user4);
            userRepo.save(user5);
            userRepo.save(user6);
            userRepo.save(user7);
            userRepo.save(user8);
            userRepo.save(user9);
            userRepo.save(user10);
            userRepo.save(user11);
            userRepo.save(user12);
            userRepo.save(user13);
            userRepo.save(user14);
            userRepo.save(user15);
            userRepo.save(user16);
            userRepo.save(user17);
            userRepo.save(user18);
            userRepo.save(user19);
            userRepo.save(user20);
            userRepo.save(user21);
            userRepo.save(user22);
            userRepo.save(user23);






            Pupil pupil2 = new Pupil("Kuba", "Wojewódzki", "412412");
            Pupil pupil3 = new Pupil("Ferdynant", "Kiepski", "51251252");
            Pupil pupil10 = new Pupil("Milan", "Wiśniewski", "97080597991");
            Pupil pupil11 = new Pupil("Kinga", "Wójcik", "98073138548");
            Pupil pupil12 = new Pupil("Nataniel", "Kaczmarek", "97041333648");
            Pupil pupil13 = new Pupil("Marek", "Krawczyk", "98040859742");
            Pupil pupil14 = new Pupil("Magda", "Piotrowska", "97091337234");
            Pupil pupil15 = new Pupil("Adela", "Kwiatkowska", "98070126133");
            Pupil pupil16 = new Pupil("Genowefa", "Grabowska", "98111981343");
            Pupil pupil17 = new Pupil("Gustaw", "Kozłowski", "98111981343");
            Pupil pupil18 = new Pupil("Danuta", "Wojciechowska", "99012259544");
            Pupil pupil19 = new Pupil("Ryszard", "Mazur", "98091899359");
            Pupil pupil20 = new Pupil("Felicja", "Dąbrowska", "98030521484");
            Pupil pupil21 = new Pupil("Aleks", "Nowak", "99051725411");
            Pupil pupil22 = new Pupil("Ida", "Kowalska", "99071789156");
            Pupil pupil23 = new Pupil("Dorian", "Chełmoński", "99010776483");

            Schollclass schollclass1 = new Schollclass(1, "A");
            Schollclass schollclass2 = new Schollclass(1, "B");
            Schollclass schollclass3 = new Schollclass(1, "C");
            Schollclass schollclass4 = new Schollclass(2, "A");
            Schollclass schollclass5 = new Schollclass(2, "B");
            Schollclass schollclass6 = new Schollclass(2, "C");
            Schollclass schollclass7 = new Schollclass(3, "A");
            Schollclass schollclass8 = new Schollclass(3, "B");
            Schollclass schollclass9 = new Schollclass(3, "C");

            schoolClassRepo.save(schollclass1);
            schoolClassRepo.save(schollclass2);
            schoolClassRepo.save(schollclass3);
            schoolClassRepo.save(schollclass4);
            schoolClassRepo.save(schollclass5);
            schoolClassRepo.save(schollclass6);
            schoolClassRepo.save(schollclass7);
            schoolClassRepo.save(schollclass8);
            schoolClassRepo.save(schollclass9);
            pupil2.setUser(user2);
            pupil3.setUser(user3);
            pupil10.setUser(user10);
            pupil11.setUser(user11);
            pupil12.setUser(user12);
            pupil13.setUser(user13);
            pupil14.setUser(user14);
            pupil15.setUser(user15);
            pupil16.setUser(user16);
            pupil17.setUser(user17);
            pupil18.setUser(user18);
            pupil19.setUser(user19);
            pupil20.setUser(user20);
            pupil21.setUser(user21);
            pupil22.setUser(user22);
            pupil23.setUser(user23);

            pupil2.setSchollclass(schollclass2);
            pupil3.setSchollclass(schollclass2);
            pupil10.setSchollclass(schollclass1);
            pupil11.setSchollclass(schollclass1);
            pupil12.setSchollclass(schollclass3);
            pupil13.setSchollclass(schollclass3);
            pupil14.setSchollclass(schollclass4);
            pupil15.setSchollclass(schollclass4);
            pupil16.setSchollclass(schollclass5);
            pupil17.setSchollclass(schollclass5);
            pupil18.setSchollclass(schollclass6);
            pupil19.setSchollclass(schollclass6);
            pupil20.setSchollclass(schollclass7);
            pupil21.setSchollclass(schollclass7);
            pupil22.setSchollclass(schollclass8);
            pupil23.setSchollclass(schollclass9);



            pupilRepo.save(pupil2);
            pupilRepo.save(pupil3);
            pupilRepo.save(pupil10);
            pupilRepo.save(pupil11);
            pupilRepo.save(pupil12);
            pupilRepo.save(pupil13);
            pupilRepo.save(pupil14);
            pupilRepo.save(pupil15);
            pupilRepo.save(pupil16);
            pupilRepo.save(pupil17);
            pupilRepo.save(pupil18);
            pupilRepo.save(pupil19);
            pupilRepo.save(pupil20);
            pupilRepo.save(pupil21);
            pupilRepo.save(pupil22);
            pupilRepo.save(pupil23);


            Teacher teacher1 = new Teacher("Janusz", "Pędziwiatr", "1256231");
            Teacher teacher4 = new Teacher("Eugeniusz", "Jabłoński", "99111164235");
            Teacher teacher5 = new Teacher("Dobrogost", "Czerwinski", "97040499916");
            Teacher teacher6 = new Teacher("Jadwiga", "Szczepańska", "97091337234");
            Teacher teacher7 = new Teacher("Bartosz", "Szymański", "98040859742");
            Teacher teacher8 = new Teacher("Mieszko", "Zieliński", "97080597991");
            Teacher teacher9 = new Teacher("Jerzy", "Lewandowski", "98073138548");






            teacher1.setUser(user1);
            teacher4.setUser(user4);
            teacher5.setUser(user5);
            teacher6.setUser(user6);
            teacher7.setUser(user7);
            teacher8.setUser(user8);
            teacher9.setUser(user9);

            teacherRepo.save(teacher1);
            teacherRepo.save(teacher4);
            teacherRepo.save(teacher5);
            teacherRepo.save(teacher6);
            teacherRepo.save(teacher7);
            teacherRepo.save(teacher8);
            teacherRepo.save(teacher9);


            Lesson matematyka1 = new Lesson(schollclass1,teacher1,"matematyka");
            Lesson matematyka2 = new Lesson(schollclass2,teacher1,"matematyka");
            Lesson matematyka3 = new Lesson(schollclass3,teacher1,"matematyka");
            Lesson matematyka4 = new Lesson(schollclass4,teacher1,"matematyka");
            Lesson matematyka5 = new Lesson(schollclass5,teacher1,"matematyka");
            Lesson matematyka6 = new Lesson(schollclass6,teacher1,"matematyka");
            Lesson matematyka7 = new Lesson(schollclass7,teacher1,"matematyka");
            Lesson matematyka8 = new Lesson(schollclass8,teacher1,"matematyka");
            Lesson matematyka9 = new Lesson(schollclass9,teacher1,"matematyka");

            Lesson polski1 = new Lesson(schollclass1,teacher4,"Polski");
            Lesson polski2 = new Lesson(schollclass2,teacher4,"Polski");
            Lesson polski3 = new Lesson(schollclass3,teacher4,"Polski");
            Lesson polski4 = new Lesson(schollclass4,teacher4,"Polski");
            Lesson polski5 = new Lesson(schollclass5,teacher4,"Polski");
            Lesson polski6 = new Lesson(schollclass6,teacher4,"Polski");
            Lesson polski7 = new Lesson(schollclass7,teacher4,"Polski");
            Lesson polski8 = new Lesson(schollclass8,teacher4,"Polski");
            Lesson polski9 = new Lesson(schollclass9,teacher4,"Polski");


            Lesson historia1 = new Lesson(schollclass1,teacher5,"Historia");
            Lesson historia2 = new Lesson(schollclass2,teacher5,"Historia");
            Lesson historia3 = new Lesson(schollclass3,teacher5,"Historia");
            Lesson historia4 = new Lesson(schollclass4,teacher5,"Historia");
            Lesson historia5 = new Lesson(schollclass5,teacher5,"Historia");
            Lesson historia6 = new Lesson(schollclass6,teacher5,"Historia");
            Lesson historia7 = new Lesson(schollclass7,teacher5,"Historia");
            Lesson historia8 = new Lesson(schollclass8,teacher5,"Historia");
            Lesson historia9 = new Lesson(schollclass9,teacher5,"Historia");


            Lesson fizyka1 = new Lesson(schollclass1,teacher6,"Fizyka");
            Lesson fizyka2 = new Lesson(schollclass2,teacher6,"Fizyka");
            Lesson fizyka3 = new Lesson(schollclass3,teacher6,"Fizyka");
            Lesson fizyka4 = new Lesson(schollclass4,teacher6,"Fizyka");
            Lesson fizyka5 = new Lesson(schollclass5,teacher6,"Fizyka");
            Lesson fizyka6 = new Lesson(schollclass6,teacher6,"Fizyka");
            Lesson fizyka7 = new Lesson(schollclass7,teacher6,"Fizyka");
            Lesson fizyka8 = new Lesson(schollclass8,teacher6,"Fizyka");
            Lesson fizyka9 = new Lesson(schollclass9,teacher6,"Fizyka");


            Lesson geografia1 = new Lesson(schollclass1,teacher7,"Geografia");
            Lesson geografia2 = new Lesson(schollclass2,teacher7,"Geografia");
            Lesson geografia3 = new Lesson(schollclass3,teacher7,"Geografia");
            Lesson geografia4 = new Lesson(schollclass4,teacher7,"Geografia");
            Lesson geografia5 = new Lesson(schollclass5,teacher7,"Geografia");
            Lesson geografia6 = new Lesson(schollclass6,teacher7,"Geografia");
            Lesson geografia7 = new Lesson(schollclass7,teacher7,"Geografia");
            Lesson geografia8 = new Lesson(schollclass8,teacher7,"Geografia");
            Lesson geografia9 = new Lesson(schollclass9,teacher7,"Geografia");

            Lesson angielski1 = new Lesson(schollclass1,teacher8,"Angielski");
            Lesson angielski2 = new Lesson(schollclass2,teacher8,"Angielski");
            Lesson angielski3 = new Lesson(schollclass3,teacher8,"Angielski");
            Lesson angielski4 = new Lesson(schollclass4,teacher8,"Angielski");
            Lesson angielski5 = new Lesson(schollclass5,teacher8,"Angielski");
            Lesson angielski6 = new Lesson(schollclass6,teacher8,"Angielski");
            Lesson angielski7 = new Lesson(schollclass7,teacher8,"Angielski");
            Lesson angielski8 = new Lesson(schollclass8,teacher8,"Angielski");
            Lesson angielski9 = new Lesson(schollclass9,teacher8,"Angielski");

            Lesson muzyka1 = new Lesson(schollclass1,teacher9,"Muzyka");
            Lesson muzyka2 = new Lesson(schollclass2,teacher9,"Muzyka");
            Lesson muzyka3 = new Lesson(schollclass3,teacher9,"Muzyka");
            Lesson muzyka4 = new Lesson(schollclass4,teacher9,"Muzyka");
            Lesson muzyka5 = new Lesson(schollclass5,teacher9,"Muzyka");
            Lesson muzyka6 = new Lesson(schollclass6,teacher9,"Muzyka");
            Lesson muzyka7 = new Lesson(schollclass7,teacher9,"Muzyka");
            Lesson muzyka8 = new Lesson(schollclass8,teacher9,"Muzyka");
            Lesson muzyka9 = new Lesson(schollclass9,teacher9,"Muzyka");


            lessonRepo.save(matematyka1);
            lessonRepo.save(matematyka2);
            lessonRepo.save(matematyka3);
            lessonRepo.save(matematyka4);
            lessonRepo.save(matematyka5);
            lessonRepo.save(matematyka6);
            lessonRepo.save(matematyka7);
            lessonRepo.save(matematyka8);
            lessonRepo.save(matematyka9);

            lessonRepo.save(polski1);
            lessonRepo.save(polski2);
            lessonRepo.save(polski3);
            lessonRepo.save(polski4);
            lessonRepo.save(polski5);
            lessonRepo.save(polski6);
            lessonRepo.save(polski7);
            lessonRepo.save(polski8);
            lessonRepo.save(polski9);

            lessonRepo.save(historia1);
            lessonRepo.save(historia2);
            lessonRepo.save(historia3);
            lessonRepo.save(historia4);
            lessonRepo.save(historia5);
            lessonRepo.save(historia6);
            lessonRepo.save(historia7);
            lessonRepo.save(historia8);
            lessonRepo.save(historia9);

            lessonRepo.save(fizyka1);
            lessonRepo.save(fizyka2);
            lessonRepo.save(fizyka3);
            lessonRepo.save(fizyka4);
            lessonRepo.save(fizyka5);
            lessonRepo.save(fizyka6);
            lessonRepo.save(fizyka7);
            lessonRepo.save(fizyka8);
            lessonRepo.save(fizyka9);

            lessonRepo.save(geografia1);
            lessonRepo.save(geografia2);
            lessonRepo.save(geografia3);
            lessonRepo.save(geografia4);
            lessonRepo.save(geografia5);
            lessonRepo.save(geografia6);
            lessonRepo.save(geografia7);
            lessonRepo.save(geografia8);
            lessonRepo.save(geografia9);


            lessonRepo.save(angielski1);
            lessonRepo.save(angielski2);
            lessonRepo.save(angielski3);
            lessonRepo.save(angielski4);
            lessonRepo.save(angielski5);
            lessonRepo.save(angielski6);
            lessonRepo.save(angielski7);
            lessonRepo.save(angielski8);
            lessonRepo.save(angielski9);

            lessonRepo.save(muzyka1);
            lessonRepo.save(muzyka2);
            lessonRepo.save(muzyka3);
            lessonRepo.save(muzyka4);
            lessonRepo.save(muzyka5);
            lessonRepo.save(muzyka6);
            lessonRepo.save(muzyka7);
            lessonRepo.save(muzyka8);
            lessonRepo.save(muzyka9);
        }
    }
}