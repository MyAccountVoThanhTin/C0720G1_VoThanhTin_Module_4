package com.codegym.controller;

import com.codegym.entity.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping({"","/list"})
    public String findAll(Model model, @PageableDefault Pageable pageable){
        model.addAttribute("listStudent",studentService.findAll(pageable));
        return "showlist";
    }

    @GetMapping("/create")
    public String getStudent(Model model){
        model.addAttribute("student", new Student());
        return "/index";
    }

    @PostMapping("/create")
    public String saveCreate(@ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/student/list";
    }
}
