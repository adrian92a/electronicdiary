package pl.javastart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.javastart.DTO.RegisterKeyAndRoleDTO;
import pl.javastart.DTO.UserDTO;
import pl.javastart.model.RegisterKey.RegisterKey;
import pl.javastart.model.RegisterKey.RoleKey;

import pl.javastart.model.User.Role;
import pl.javastart.model.User.User;

import pl.javastart.repository.RegisterKeyRepository;
import pl.javastart.repository.RoleRepository;
import pl.javastart.repository.UserRepository;

import javax.validation.Valid;
import java.util.*;


@Service
public class UserService   {

    private UserRepository userRepo;
    private RegisterKeyRepository registerKeyRepo;
    private RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepo, RegisterKeyRepository registerKeyRepo, RoleRepository roleRepository) {
        this.userRepo = userRepo;
        this.registerKeyRepo = registerKeyRepo;
        this.roleRepository = roleRepository;
    }

    public void registerNewAccount(RegisterKeyAndRoleDTO registerKeyAndRoleDTO) {

            User user = new User();
            user.setLogin(registerKeyAndRoleDTO.getEmail());
            user.setPassword(registerKeyAndRoleDTO.getPassword());
            userRepo.findByEmail(registerKeyAndRoleDTO.getEmail());


            Set<RoleKey> registerKeyRoles =registerKeyRepo.findRegisterKeyRoleName(registerKeyAndRoleDTO.getKeyRegisterValue());
        userRepo.save(user);
            for(RoleKey r:registerKeyRoles)
            {
                Role role=new Role();
                role.setRoleName(r.getRoleName());
                role.setUser(user);
                roleRepository.save(role);
            }


    }


    public void setRegisterKeyUsedValueAndRedirect(@ModelAttribute RegisterKeyAndRoleDTO userRegisterDTO) {
        RegisterKey key = registerKeyRepo.findByRegisterey(userRegisterDTO.getKeyRegisterValue());
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