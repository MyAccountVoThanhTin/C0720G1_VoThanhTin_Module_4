package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FanpageController {

    @RequestMapping({"","/home"})
    private ModelAndView gohome(){
        return new ModelAndView("index");
    }
}
