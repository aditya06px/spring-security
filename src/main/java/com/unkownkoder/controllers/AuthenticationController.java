package com.unkownkoder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unkownkoder.models.ApplicationUser;
import com.unkownkoder.models.LoginResponseDTO;
import com.unkownkoder.models.RegistrationDTO;
import com.unkownkoder.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register/jobseeker")
    public ApplicationUser registerJobSeeker(@RequestBody RegistrationDTO body) {
    	System.out.println("inside register jobseeker");
    	
        return authenticationService.registerUser(body.getUsername(), body.getPassword(), "jobseeker");
    }
    
    @PostMapping("/register/recruiter")
    public ApplicationUser registerRecruiter(@RequestBody RegistrationDTO body) {
        return authenticationService.registerUser(body.getUsername(), body.getPassword(), "recruiter");
    }
    
    @PostMapping("/login/jobseeker")
    public LoginResponseDTO loginJobSeeker(@RequestBody RegistrationDTO body) {
    	System.out.println("inside login jobseeker");
        return authenticationService.loginJobSeeker(body.getUsername(), body.getPassword());
    }
    

    
    @PostMapping("/login/recruiter")
    public LoginResponseDTO loginRecruiter(@RequestBody RegistrationDTO body) {
        return authenticationService.loginRecruiter(body.getUsername(), body.getPassword());
    }
    
    @GetMapping("/home")
    public String home(){
        return "auth Home";
    }
    
    @GetMapping("/")
    public String Firsthome(){
        return "auth / / / / Home";
    }

}
