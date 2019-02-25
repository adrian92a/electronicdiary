package pl.javastart.serive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javastart.model.User;
import pl.javastart.model.UserDTO;
import pl.javastart.repository.UserRepository;


@Service
public class UserService   {
    @Autowired
    public UserRepository userRepo;


    public User registerNewUserAccount(UserDTO accountDto) {
        if (emailDoesntExist(accountDto.getEmail())) {
            User user = new User();
            user.setLogin(accountDto.getEmail());
            user.setPassword(accountDto.getPassword());
            user.setRole(accountDto.getRole());
            return user;
        }
        else {
            return null;
        }
    }
    public Boolean emailDoesntExist(String email) {
return userRepo.checkIfDoesntExistByEmail(email);
    }
}