package com.unkownkoder.configuration;

import java.util.List;

import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class CustomAuthenticationEvent extends AbstractAuthenticationEvent {

    private Authentication authentication;
    private HttpServletRequest request;
    private List<String> databasesLoaded;

    public CustomAuthenticationEvent(Authentication authentication, HttpServletRequest request, List<String> databasesLoaded) {
        super(authentication);
        this.authentication = authentication;
        this.request = request;
        this.databasesLoaded = databasesLoaded;
    }
    


    
}