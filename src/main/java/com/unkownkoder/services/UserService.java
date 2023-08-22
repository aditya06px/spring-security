package com.unkownkoder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unkownkoder.models.ApplicationUser;
import com.unkownkoder.models.Role;
import com.unkownkoder.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("com.unkownkoder.services.UserService");
           //returning Application user
        ApplicationUser temp =  userRepository.findByUsername(username).get();
        System.out.println("***** " + temp.getUsername() + " ****** "   );
        temp.getAuthorities().forEach(a -> System.out.println(a.getAuthority()));
        System.out.println("*********************************");
        
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }
    
    
    public List<ApplicationUser> getUsersByRole(Role roleAuthority) {
        return userRepository.findByAuthoritiesAuthority(roleAuthority);
    }
}
