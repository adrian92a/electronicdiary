package pl.javastart.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import pl.javastart.model.Pupil;

@Controller
public class AddPupil {
    @GetMapping("/addpupil")
    public String home(Model model) {
        model.addAttribute("pupilModel", new Pupil());
        return "addpupil";
    }  
}