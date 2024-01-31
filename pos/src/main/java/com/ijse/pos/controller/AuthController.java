package com.ijse.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos.dto.LoginDto;
import com.ijse.pos.entity.User;
import com.ijse.pos.repository.UserRepository;
import com.ijse.pos.security.jwt.jwtUtils;
import com.ijse.pos.service.UserService;



@RestController
@CrossOrigin(origins="*")
public class AuthController {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired

    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private jwtUtils jwtUtils;
    @GetMapping("/auth/login")
    public String login(){
        return "login without atherization";
    }
    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        if(userRepository.existsByUsername(user.getUsername())){
            return ResponseEntity.badRequest().body("Username is already used");
        }
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body("Email is already used");
        }
        User newuser=new User();
        newuser.setUsername(user.getUsername());
        newuser.setEmail(user.getEmail());
        newuser.setRole(user.getRole());
        newuser.setPassword(passwordEncoder.encode(user.getPassword()));
        

        return ResponseEntity.ok(userService.createUser(newuser));

    }

    @PostMapping("/auth/login")

//     public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
//         Authentication authentication=authenticationManager.authenticate(
//              new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())

//         );
//         SecurityContextHolder.getContext().setAuthentication(authentication);
//         String jwt=jwtUtils.genetateJwtToken(authentication);
//         return ResponseEntity.ok(jwt);
// }

public ResponseEntity<?> login(@RequestBody LoginDto loginDTO) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String token = jwtUtils.genetateJwtToken(authentication);

    return ResponseEntity.ok().body(token);
}
}
