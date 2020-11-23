package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.SumService;

@Controller
public class SumController {
    @Qualifier("sum2Number")
    @Autowired
    private SumService sumService;

    @GetMapping({"/sum2num"})
    public String sum(@RequestParam String num1,@RequestParam(value = "num2") String b, Model model){
        int resultSum =sumService.sum2Number(Integer.parseInt(num1),Integer.parseInt(b));
        model.addAttribute("resultSum",resultSum);
        return "resultSum";
    }
}
