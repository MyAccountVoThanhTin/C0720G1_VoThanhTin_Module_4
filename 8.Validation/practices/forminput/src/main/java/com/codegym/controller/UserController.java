package com.codegym.controller;

import com.codegym.entity.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Qualifier("userService")
    @Autowired
    private UserService userService;

    @GetMapping({"","/list"})
    public String goHome(Model model){
        model.addAttribute("listUser",userService.findAll());
        return "/listuser";
    }

    @GetMapping("/create")
    public String getUser(Model model){
        model.addAttribute("user",new User());
        return "/create";
    }

    @PostMapping("/validateUser")
    public String saveUser(@Validated @ModelAttribute User user, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "/create";
        }else {
            userService.save(user);
            return "redirect:/user/list";
        }
    }
}
