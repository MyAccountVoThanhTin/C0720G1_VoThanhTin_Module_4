package com.codegym.controller;

import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping({"","/"})
    public String showAll(Model model){
        model.addAttribute("listCustomer",customerService.getAll());
        return "/index";
    }
}
