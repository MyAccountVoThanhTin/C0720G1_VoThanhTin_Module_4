package com.codegym.controller;

import com.codegym.entity.Mycounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("mycounter")
public class CountController {

    @ModelAttribute("mycounter")
    public Mycounter setUpCounter() {
        return new Mycounter();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("mycounter") Mycounter mycounter) {
        mycounter.increment();
        return "/index";
    }
}
