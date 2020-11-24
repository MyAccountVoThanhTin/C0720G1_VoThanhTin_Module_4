package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentsController {
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save(@RequestParam(value = "condiment", defaultValue = "") String[] condiment, Model model) {
        StringBuilder stringBuilder = new StringBuilder();
//        if(condiment.length-1 < 0){
//            stringBuilder = stringBuilder.append("null");
//        }else {
        for (int i = 0; i <= condiment.length - 1; i++) {
            if (i < condiment.length - 1) {
                stringBuilder.append(condiment[i]).append(",");
            } else if (i == condiment.length - 1) {
                stringBuilder.append(condiment[i]);
            }
        }
        model.addAttribute("list", stringBuilder);
        return "index";
    }
}
