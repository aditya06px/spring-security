package com.unkownkoder.configuration;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        // This method is called after a failed authentication due to bad credentials
        // You can log relevant information about the failed authentication
        String username = event.getAuthentication().getName();
        // Log more details if needed
        System.out.println("Failed authentication attempt for user: " + username);
    }
}