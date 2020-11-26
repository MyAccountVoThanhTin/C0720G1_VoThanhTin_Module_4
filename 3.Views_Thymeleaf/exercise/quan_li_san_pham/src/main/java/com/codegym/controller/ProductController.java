package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping({"","/"})
    public String showList(Model model){
        model.addAttribute("listProduct",productService.getAll());
        return "/showlist";
    }

    @GetMapping("/edit/{id}/product")
    public String editProduct(@PathVariable int id,Model model){
        model.addAttribute("product",productService.getById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/";
    }

    @PostMapping
    public String update(RedirectAttributes redirect, @ModelAttribute Product product){
        productService.update(product.getId(),product);
        return "redirect:/";
    }

    @GetMapping("/details/{id}/product")
    public String viewsDetails(@PathVariable int id , Model model){
        model.addAttribute("product",productService.getById(id));
        return "/viewsdetails";
    }

    @GetMapping("/delete/{id}/product")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/comback")
    public String comeBackList(){
        return "redirect:/";
    }
}
