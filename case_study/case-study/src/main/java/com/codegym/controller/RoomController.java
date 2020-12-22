package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoomController {

    @RequestMapping("/room")
    public ModelAndView goRoom(){
        return new ModelAndView("room");
    }
}
