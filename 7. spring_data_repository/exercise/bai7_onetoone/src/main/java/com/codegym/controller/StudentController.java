package com.codegym.controller;

import com.codegym.entity.Address;
import com.codegym.entity.Student;
import com.codegym.service.AddressService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Qualifier("studentServicesImpl")
    @Autowired
    private StudentService studentService;

    @Autowired
    private AddressService addressService;

    @GetMapping({"","/list"})
    public String getAll(Model model, @PageableDefault(size = 2) Pageable page){
        model.addAttribute("listStudent", studentService.findAll(page));
        return "/showlist";
    }

    @GetMapping("/create")
    public String getStudent(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("address",new Address());
        return "/create";
    }

    @PostMapping("/savecreate")
    public String savecreate(@ModelAttribute Student student , @ModelAttribute Address address){
        addressService.save(address);
        student.setAddress(address);
        studentService.save(student);
        return "redirect:/student/list";
    }
}
