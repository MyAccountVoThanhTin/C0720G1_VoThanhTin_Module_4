package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    private ModelAndView gohome(){
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    private ModelAndView hello(){
        return new ModelAndView("hello");
    }
}
