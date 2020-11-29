package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.service.CustoemrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Qualifier("customerserviceImpl")
    @Autowired
    private CustoemrService custoemrService;

    @GetMapping({"","/list"})
    public String findAll(Model model){
        model.addAttribute("listCustomer",custoemrService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String getCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","Save Success !");
        custoemrService.save(customer);
        return "redirect:/customer/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer delete){
        custoemrService.delete(custoemrService.findById(delete));
        return "redirect:/customer/list";
    }
}
