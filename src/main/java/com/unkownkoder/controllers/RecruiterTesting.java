package com.unkownkoder.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recruiter")
@CrossOrigin("*")
public class RecruiterTesting {

    @GetMapping("/")
    public String helloUserController(){
        return "Recruiter Testing access level";
    }
    
    @GetMapping("/home")
    public String home(){
        return "Recruiter home";
    }
    
}
