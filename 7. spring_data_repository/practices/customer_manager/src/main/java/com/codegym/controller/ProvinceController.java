package com.codegym.controller;

import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Qualifier("provinceServiceImpl")
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("listProvince", provinceService.findAll());
        return null;
    }
}
