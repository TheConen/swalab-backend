package com.swalab.backend.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Autowired
    public testController() {
        //ToDo
    }
    
    @GetMapping("/hello")
    public String getHello() {
        return "Hello World! " + Math.random();
    }

    
}