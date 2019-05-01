package pl.javastart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.javastart.DTO.RegisterKeyAndRoleDTO;
import pl.javastart.DTO.UserDTO;
import pl.javastart.model.Pupil;
import pl.javastart.model.RegisterKey.RegisterKey;
import pl.javastart.model.RegisterKey.RoleKey;

import pl.javastart.model.Schollclass;
import pl.javastart.model.Teacher;
import pl.javastart.model.User.Role;
import pl.javastart.model.User.User;

import pl.javastart.repository.*;

import javax.validation.Valid;
import java.util.*;


@Service
public class UserService   {

    private UserRepository userRepo;
    private RegisterKeyRepository registerKeyRepo;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private SchoolClassRepository schoolClassRepo;
    private PupilRepository pupilRepo;
    private TeacherRepository teacherRepo;
    @Autowired
    public UserService(UserRepository userRepo, RegisterKeyRepository registerKeyRepo, RoleRepository roleRepository, PasswordEncoder passwordEncoder, SchoolClassRepository schoolClassRepo, PupilRepository pupilRepo,  TeacherRepository teacherRepo)
    {
        this.userRepo = userRepo;
        this.registerKeyRepo = registerKeyRepo;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.schoolClassRepo = schoolClassRepo;
        this.pupilRepo = pupilRepo;
        this.teacherRepo = teacherRepo;
    }

    public void registerNewAccount(RegisterKeyAndRoleDTO registerKeyAndRoleDTO) {

            User user = new User();
            user.setLogin(registerKeyAndRoleDTO.getEmail());
            user.setPassword(passwordEncoder.encode(registerKeyAndRoleDTO.getPassword()));
            userRepo.findByEmail(registerKeyAndRoleDTO.getEmail());


            Set<RoleKey> registerKeyRoles =registerKeyRepo.findRegisterKeyRoleName(registerKeyAndRoleDTO.getKeyRegisterValue());

            for(RoleKey r:registerKeyRoles)
            {
                Optional<Role> role= roleRepository.findByRoleName(r.getRoleName());
                user.addRole(role.get());
            }
             userRepo.save(user);
            if(registerKeyAndRoleDTO.getSchollClassLetter()!=null)
            {
                Pupil pupil=new Pupil(registerKeyAndRoleDTO.getFirstName(),registerKeyAndRoleDTO.getLastName(),registerKeyAndRoleDTO.getPesel());
                Schollclass schollclass;
                Integer schoolClassId= (schoolClassRepo.findScholdClassByClassNumberAndClassLetter(registerKeyAndRoleDTO.schollClassnumber,registerKeyAndRoleDTO.getSchollClassLetter()));
                schollclass=schoolClassRepo.getOne(schoolClassId);
                pupil.setUser(user);
                pupil.setSchollclass(schollclass);
                pupilRepo.save(pupil);
            }
            if(registerKeyAndRoleDTO.getSchollClassLetter()==null)
            {
                Teacher teacher= new Teacher(registerKeyAndRoleDTO.getFirstName(),registerKeyAndRoleDTO.getLastName(),registerKeyAndRoleDTO.getPesel());
                teacher.setUser(user);
                teacherRepo.save(teacher);
            }

    }


    public void setRegisterKeyUsedValueAndRedirect(@ModelAttribute RegisterKeyAndRoleDTO userRegisterDTO) {
        RegisterKey key = registerKeyRepo.findByKeyRegisterValue(userRegisterDTO.getKeyRegisterValue()).get();
        key.setUsed(true);
        registerKeyRepo.save(key);
    }

    public boolean existRegisterKeyAndIsntUsed(String key)
    {
        List<RegisterKey> registerkeys =  registerKeyRepo.findAll();
        for(RegisterKey registerkey : registerkeys )
        {
            if(registerkey.getKeyRegisterValue().equals(key))
            {
                if(registerkey.getUsed()==false)
                {
                    System.out.println(registerkey.getKeyRegisterValue());
                    return true;
                }
            }
        }
        return false;
    }

    public RegisterKeyAndRoleDTO getRegisterKeyAndRoleDTO(@Valid UserDTO userDTO, RegisterKey registerKey) {

        RegisterKeyAndRoleDTO registerKeyAndRoleDTO = new RegisterKeyAndRoleDTO();
        registerKeyAndRoleDTO.setKeyRegisterValue(registerKey.getKeyRegisterValue());
        registerKeyAndRoleDTO.setFirstName(registerKey.getFirstName());
        registerKeyAndRoleDTO.setLastName(registerKey.getLastName());
        registerKeyAndRoleDTO.setPesel(registerKey.getPesel());
        registerKeyAndRoleDTO.setSchollClassLetter(registerKey.getSchollClassLetter());
        registerKeyAndRoleDTO.setSchollClassnumber(registerKey.getSchollClassnumber());
        registerKeyAndRoleDTO.setEmail(userDTO.getEmail());
        registerKeyAndRoleDTO.setPassword(userDTO.getPassword());

        return registerKeyAndRoleDTO;
    }




    public Boolean emailDoesntExist(String email) {
return userRepo.checkIfDoesntExistByEmail(email);
    }
}