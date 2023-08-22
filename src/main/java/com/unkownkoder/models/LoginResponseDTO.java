package com.unkownkoder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private ApplicationUser user;
    private String jwt;
    private String userType; // "jobseeker" or "recruiter"
   
}
