package com.codegym.controller;

import com.codegym.entity.Login;
import com.codegym.entity.User;
import com.codegym.service.LoginService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ModelAndView login(){
        return new ModelAndView("/login","login", new Login());
    }

    @GetMapping("/gohome")
    public ModelAndView gohome(){
        return new ModelAndView("/index");
    }

    @PostMapping("/checklogin")
    public String checklogin(@ModelAttribute("user") User user, @ModelAttribute Login login, Model model){
//        Login login1 = loginService.findByName(login.getUserName());
//        if((login.getUserName() == "") || (login.getPassword() == "")){
//            model.addAttribute("login", new Login());
//            return "login";
//        }else if ((loginService.findByName(login.getUserName()) == null){
//            model.addAttribute("login", new Login());
//            return "login";
//        }else{
//            return
//        }
        if(!(login.getUserName().equals("")) && !(login.getPassword().equals(""))){
            Login login1 = loginService.findByName(login.getUserName());
            if (login.getUserName().equals(login1.getUserName()) && login.getPassword().equals(login1.getPassword())){
                user = login1.getUser();
                model.addAttribute("user",user);
                return "index";
            }
        }
        return "login";
    }
}
