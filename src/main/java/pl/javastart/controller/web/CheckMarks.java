package pl.javastart.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CheckMarks {
    @GetMapping("/checkmarks")
    public String home() {
        return "checkmarks";
    }
}

