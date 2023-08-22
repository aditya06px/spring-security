package com.unkownkoder;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.unkownkoder.models.ApplicationUser;
import com.unkownkoder.models.Role;
import com.unkownkoder.repository.RoleRepository;
import com.unkownkoder.repository.UserRepository;

@SpringBootApplication
public class AuthenticatedBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthenticatedBackendApplication.class, args);
	}

//	securityContextHolder => just a static holder of authentication
	// this variable is local thread so will not be accessible to it's childs threads
	
	
	// SecurityFilterChain
	
	// just a utility to populate the data 
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
	    return args -> {
	        if (roleRepository.findByAuthority("ADMIN").isPresent()) return;

	        Role adminRole = roleRepository.save(new Role("ADMIN"));
	        Role userRole = roleRepository.save(new Role("USER"));
	        Role jobseekerRole = roleRepository.save(new Role("JOBSEEKER"));
	        Role recruiterRole = roleRepository.save(new Role("RECRUITER"));

//	        Set<Role> adminRoles = new HashSet<>();
//	        adminRoles.add(adminRole);

	        ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncoder.encode("password"), adminRole);
	        userRepository.save(admin);

//	        Set<Role> userRoles = new HashSet<>();
//	        userRoles.add(userRole);
//
//	        ApplicationUser user = new ApplicationUser(2, "user", passwordEncoder.encode("password"), userRoles);
//	        userRepository.save(user);

//	        Set<Role> jobseekerRoles = new HashSet<>();
//	        jobseekerRoles.add(jobseekerRole);

	        ApplicationUser jobseeker = new ApplicationUser(3, "jobseeker", passwordEncoder.encode("password"), jobseekerRole);
	        userRepository.save(jobseeker);

//	        Set<Role> recruiterRoles = new HashSet<>();
//	        recruiterRoles.add(recruiterRole);

	        ApplicationUser recruiter = new ApplicationUser(4, "recruiter", passwordEncoder.encode("password"), recruiterRole);
	        userRepository.save(recruiter);
	    };
	}

}
