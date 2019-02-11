package pl.javastart.controller.web;

import org.springframework.web.bind.annotation.GetMapping;

public class Home {
    @GetMapping("/selectformget")
    public String home() {
        return "selectformget";
    }
}