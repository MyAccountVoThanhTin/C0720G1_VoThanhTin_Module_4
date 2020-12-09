package com.codegym.controller;

import com.codegym.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping({"","/student"})
public class StudentController {

    @GetMapping("")
    public ModelAndView goHome(){
        ModelAndView modelAndView = new ModelAndView("validateform","student",new Student());
        return modelAndView;
    }


    @GetMapping("/create")
    public String create(@Valid @ModelAttribute Student student, BindingResult bindingResult, Model model){
        new Student().validate(student,bindingResult);
        if(bindingResult.hasErrors()){
//            model.addAttribute("");
            return "validateform";
        }else {
            return "succes";
        }

    }
}
