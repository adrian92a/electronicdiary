package pl.javastart.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.javastart.model.User;
@Controller
public class CheckMarks {
    @GetMapping("/checkmarks")
    public String home() {
        return "checkmarks";
    }  
}
