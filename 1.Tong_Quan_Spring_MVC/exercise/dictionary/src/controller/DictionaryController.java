package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IDictionary;

import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionary dictionary;

    @GetMapping({"","/trangchu"})
    public String trangChu(){
        return "trangchu";
    }

    @GetMapping({"/find"})
    public String find(@RequestParam String find, Model model){
        Map<String,String> listDictionary = dictionary.findDictionary();
        String result = listDictionary.get(find);
        if(result == null){
            model.addAttribute("result","Not Found !");
        }else {
            model.addAttribute("result",result);
        }
        return "trangchu";
    }

}
