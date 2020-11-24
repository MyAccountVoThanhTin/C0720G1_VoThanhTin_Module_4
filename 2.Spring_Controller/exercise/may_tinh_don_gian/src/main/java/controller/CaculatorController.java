package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

    @GetMapping({"","/home"})
    public String goHome(){
        return "index";
    }

    @PostMapping("/caculator")
    public String caculator(@RequestParam Integer num1, @RequestParam Integer num2, @RequestParam String caculator, Model model){
        if(caculator.equals("Addition(+)")){
            model.addAttribute("result","Addition : "+(num1+num2));
        }else if (caculator.equals("Subtraction(-)")){
            model.addAttribute("result","Subtraction : "+(num1-num2));
        } else if (caculator.equals("Multiplication(X)")) {
            model.addAttribute("result","Multiplication : "+(num1*num2));
        }else if (caculator.equals("Division(/)")){
            if (num1 == 0){
                model.addAttribute("result","Not Division When numerator is 0 !");
            }else {
                model.addAttribute("result","Division : "+(num1/num2));
            }
        }
        return "index";
    }
}
