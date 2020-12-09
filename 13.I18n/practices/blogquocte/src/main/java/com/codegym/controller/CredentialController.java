package com.codegym.controller;

import com.codegym.entity.Credential;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"","/credential"})
public class CredentialController {

    @GetMapping("/")
    public ModelAndView gohome(){
        return new ModelAndView("home","credential",new Credential());
    }

    @GetMapping("/list")
    public ModelAndView go(){
        return new ModelAndView("dashboard");
    }
}
