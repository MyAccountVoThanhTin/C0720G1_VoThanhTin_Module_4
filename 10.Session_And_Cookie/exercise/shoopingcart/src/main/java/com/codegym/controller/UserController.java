package com.codegym.controller;

import com.codegym.entity.User;
import com.codegym.service.ShoppingCartService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes("user")
@RequestMapping({"","/user"})
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartService shoppingCartService;

//    @GetMapping("/login")
//    public ModelAndView login(){
//        ModelAndView modelAttribute = new ModelAndView("/login","userlogin",new User());
//        return modelAttribute;
//    }

}
