package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.service.CustoemrService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Qualifier("customerserviceImpl")
    @Autowired
    private CustoemrService custoemrService;

    @Qualifier("provinceServiceImpl")
    @Autowired
    private ProvinceService provinceService;

    @GetMapping({"","/list"})
    public String findAll(Model model,@PageableDefault(size = 2) Pageable pageable,@RequestParam Optional<String> keyword){

        String keywordAfterCheck = "";
        if(!keyword.isPresent()){
            model.addAttribute("listCustomer",custoemrService.findAll(pageable));
        }else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("listCustomer",custoemrService.search(keywordAfterCheck,pageable));
        }
        model.addAttribute("keywordAfterCheck",keywordAfterCheck);
        return "/index";
    }

    @GetMapping("/create")
    public String getCustomer(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("listProvince",provinceService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer,@RequestParam Integer province, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","Save Success !");
        customer.setProvince(provinceService.findById(province));
        custoemrService.save(customer);
        return "redirect:/customer/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer delete){
        custoemrService.delete(custoemrService.findById(delete));
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id,Model model){
        model.addAttribute("customer",custoemrService.findById(id));
        return "/edit";
    }

    @PostMapping("/saveedit")
    public String saveEdit(@ModelAttribute Customer customer){
        custoemrService.save(customer);
        return "redirect:/customer/list";
    }
}
