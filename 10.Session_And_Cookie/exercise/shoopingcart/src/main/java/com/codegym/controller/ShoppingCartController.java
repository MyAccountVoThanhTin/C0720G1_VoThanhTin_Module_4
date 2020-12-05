package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.entity.ShoppingCart;
import com.codegym.entity.User;
import com.codegym.service.ProductService;
import com.codegym.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"","/cart"})
@SessionAttributes("user")
public class ShoppingCartController {
    @Autowired
    private ProductService productService;

    @PostMapping("/viewcart")
    public String viewCart(@RequestParam String mycart, Model model, @ModelAttribute("user") User user){
        List<Product> productList = new ArrayList<>();
        String[] arr = mycart.split(",");
        for (int i=0;i<arr.length -1;i++){
            productList.add(productService.findById(Integer.parseInt(arr[i])));
        }
        model.addAttribute("listProductCart",productList);
        return "viewcart";
    }
}
