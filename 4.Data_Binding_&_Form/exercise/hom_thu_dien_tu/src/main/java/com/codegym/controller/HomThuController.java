package com.codegym.controller;

import com.codegym.entity.HomThu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomThuController {

    @GetMapping({"","/home"})
    public String goHome(Model model){
        model.addAttribute("homthu",new HomThu());
        List<String> listLanguages = new ArrayList<>();
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japanese");
        listLanguages.add("Chinese");
        model.addAttribute("listLanguages",listLanguages);
        int[] pageSize = {5,10,15, 25, 50, 100};
        model.addAttribute("pageSize",pageSize);
        return "index";
    }

    @PostMapping("/show")
    public String show(@ModelAttribute HomThu homthu,Model model){
        model.addAttribute("homthu",homthu);
        return "show";
    }

    @GetMapping("/homeback")
    public String homeBack(RedirectAttributes redirectAttributes){
//        redirectAttributes.addFlashAttribute("messageSuccess", "Register successfully!");
        return "redirect:/home";
    }
}
