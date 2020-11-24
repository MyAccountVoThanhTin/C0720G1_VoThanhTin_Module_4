package com.codegym.controller;

import com.codegym.service.CaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    private CaculatorService caculatorService;
    @GetMapping({"","/home"})
    public String goHome(){
        return "index";
    }

    @PostMapping("/caculator")
    public String caculator(@RequestParam(defaultValue = "0",required = false) String num1 , @RequestParam(defaultValue = "0",required = false) String num2, @RequestParam String caculator, Model model){
        model.addAttribute("result",caculatorService.caculator(num1,num2,caculator));
        return "index";
    }
}
