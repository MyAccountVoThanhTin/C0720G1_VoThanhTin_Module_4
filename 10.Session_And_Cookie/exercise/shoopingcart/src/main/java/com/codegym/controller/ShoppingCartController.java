package com.codegym.controller;
import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping({"", "/cart"})
@SessionAttributes({"user", "list"})
public class ShoppingCartController {
    @Autowired
    private ProductService productService;

    @GetMapping("/viewcart/{id}")
    public String viewCart(@PathVariable Integer id, @ModelAttribute("list") List<Product> list, Model model, @PageableDefault(size = 2) Pageable pageable) {
        list.add(productService.findById(id));
        model.addAttribute("listproductcart", list);
        model.addAttribute("listproduct", productService.findAll(pageable));
        return "showlistproduct";
    }
}
