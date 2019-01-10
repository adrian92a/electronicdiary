package pl.javastart.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.javastart.model.User;
@Controller
public class AddUser {
    @GetMapping("/adduser")
    public String home(Model model) {
        model.addAttribute("userModel", new User());
        return "adduser";
    }  
}
