package controller;

import common.UsdException;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IUsd;

@Controller
public class Usd {

    @Qualifier("usdIpl")
    @Autowired
    private IUsd usd;

    @GetMapping({"/tinh"})
    public String tinhUsd(@RequestParam String number,@RequestParam String vndUsd, Model model){
        if(vndUsd.equals("vnd")){
            try {
                model.addAttribute("usd",usd.tinhUsd("vnd",Double.parseDouble(number)));
            } catch (UsdException e) {
                e.printStackTrace();
            }
        }else {
            String exception;
            try {
                model.addAttribute("usd",usd.tinhUsd("usd",Double.parseDouble(number)));
            } catch (UsdException e) {
                exception = e.getMessage();
                model.addAttribute("usd",exception);
            }
        }
        return "usd";
    }
}
