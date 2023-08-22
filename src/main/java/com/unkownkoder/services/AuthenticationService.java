package com.unkownkoder.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unkownkoder.models.ApplicationUser;
import com.unkownkoder.models.JobSeeker;
import com.unkownkoder.models.LoginResponseDTO;
import com.unkownkoder.models.Recruiter;
import com.unkownkoder.models.Role;
import com.unkownkoder.repository.JobSeekerRepository;
import com.unkownkoder.repository.RecruiterRepository;
import com.unkownkoder.repository.RoleRepository;
import com.unkownkoder.repository.UserRepository;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JobSeekerRepository jobSeekerRepository; // Assuming you have JobSeekerRepository

    @Autowired
    private RecruiterRepository recruiterRepository;
    
    public ApplicationUser registerUser(String username, String password, String role) {

    	System.out.println("inside authnetication service");
    	
    	 String encodedPassword = passwordEncoder.encode(password);
         Role userRole = roleRepository.findByAuthority(role)
                 .orElseThrow(() -> new RuntimeException("Role not found"));

//         Set<Role> authorities = new HashSet<>();
//         authorities.add(userRole);

         ApplicationUser user = new ApplicationUser(0, username, encodedPassword, userRole);
         user = userRepository.save(user);
//
//         // Associate the user with a specific role (JobSeeker or Recruiter)
//         if ("jobseeker".equals(role)) {
//             JobSeeker jobSeeker = new JobSeeker();
//             jobSeeker.setUser(user);
//             jobSeekerRepository.save(jobSeeker);
//         } else if ("recruiter".equals(role)) {
//             Recruiter recruiter = new Recruiter();
//             recruiter.setUser(user);
//             recruiterRepository.save(recruiter);
//         }

         System.out.println("authnetication service complete");
         return user;
    }


    public LoginResponseDTO loginUser(String username, String password, String role) {

        try {
        	
        	//checks username and password matches or not 
        	// if not throws an exception
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            System.out.println("tokern is " + token);
            
            return new LoginResponseDTO(userRepository.findByUsername(username).get(), token, role);

        } catch (AuthenticationException e) {
            return new LoginResponseDTO(null, "notoken", "");
        }
    }

    public LoginResponseDTO loginJobSeeker(String username, String password) {
        return loginUser(username, password, "jobseeker");
    }

    public LoginResponseDTO loginRecruiter(String username, String password) {
        return loginUser(username, password, "recruiter");
    }
}
