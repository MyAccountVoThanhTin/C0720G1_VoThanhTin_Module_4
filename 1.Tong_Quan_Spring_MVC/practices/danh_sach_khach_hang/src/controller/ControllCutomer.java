package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.ICutomerService;

import java.util.List;

@Controller
public class ControllCutomer {

//    @Qualifier("customerService")
    @Autowired
    private ICutomerService cutomerService;

    @GetMapping("/list")
    public String showListCustomer(Model model){
        model.addAttribute("listCustomer",cutomerService.getAllCustomer());
        return "tableCustomer";
    }
}
