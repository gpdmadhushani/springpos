package com.ijse.pos.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ijse.pos.entity.User;
import com.ijse.pos.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username)  {
       User user=userRepository.findByUsername(username).orElse(null);
       if(user==null){
        throw new UsernameNotFoundException("user not found given username");
       }
       return org.springframework.security.core.userdetails.User.builder()
       .username(user.getUsername())
       .password(user.getPassword())
       .build();
    }

    
}
