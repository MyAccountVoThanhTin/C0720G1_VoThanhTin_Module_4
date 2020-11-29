package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping({"","/list"})
    public String findAll(Model model){
        model.addAttribute("listBlog",blogService.findAll());
        return "showblog";
    }

    @GetMapping("/getObject")
    public String getObject(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("message","1");
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute(value = "blog") Blog blog){
        LocalDate localDate = LocalDate.now();
        blog.setDate(String.valueOf(localDate));
        blogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping("/view/{id}")
    public String viewDetails(@PathVariable Integer id,Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "viewDetails";
    }

    @GetMapping("/combackhome")
    public String comeback(){
        return "redirect:/list";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "editblog";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        blogService.delete(blogService.findById(id));
        return "redirect:/list";
    }

    @PostMapping("/saveedit")
    public String saveEdit(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/list";
    }
}
