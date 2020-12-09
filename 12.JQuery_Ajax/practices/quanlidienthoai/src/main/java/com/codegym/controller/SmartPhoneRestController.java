package com.codegym.controller;

import com.codegym.entity.SmartPhone;
import com.codegym.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@Controller
@RequestMapping({"","/smartphone"})
public class SmartPhoneRestController {
    @Autowired
    private SmartPhoneService smartPhoneService;


    @GetMapping("")
    public ModelAndView goHome(){
        return new ModelAndView("index");
    }

    @GetMapping("/list")
    public ResponseEntity<List<SmartPhone>> showIndex(){
        List<SmartPhone> listPhone = this.smartPhoneService.findAll();
        if (listPhone.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listPhone, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerStudent(@RequestBody SmartPhone smartPhone, UriComponentsBuilder ucBuilder) {
        this.smartPhoneService.save(smartPhone);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/smartphone/list").buildAndExpand(smartPhone.getId()).toUri());
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SmartPhone> findById(@PathVariable Integer id ){
        SmartPhone smartPhone = smartPhoneService.findById(id);
        return new ResponseEntity<>(smartPhone,HttpStatus.OK);
    }
}
