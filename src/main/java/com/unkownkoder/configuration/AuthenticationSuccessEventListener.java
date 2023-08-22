package com.unkownkoder.configuration;

import java.util.Collection;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.unkownkoder.models.Role;

@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
    	
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	System.out.println(auth.isAuthenticated());
//    	System.out.println(auth.getCredentials());
//    	System.out.println(auth.getDetails());
//    	List<Role> temp = (List<Role>) auth.getAuthorities();
//    	temp.forEach(t-> {
//    		System.out.println(t.getAuthority());
//    	});

        String grantedAuthoritiesLog = event.getAuthentication().toString();
        String scopePart = grantedAuthoritiesLog.substring(grantedAuthoritiesLog.indexOf("[SCOPE_") + 7, grantedAuthoritiesLog.lastIndexOf("]"));

        System.out.println("***************");
        System.out.println(grantedAuthoritiesLog);
        System.out.println("Granted Scope or Role: " + scopePart);
        
        System.out.println("new console ");
        
 
        
    


	
}
        
    
    
    }