package com.ijse.pos.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos.dto.UserPasswordDto;
import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.User;
import com.ijse.pos.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

     @GetMapping("/hello")
    public String sayHello() {
        return "hello spring boot";
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}/change-password")

    public ResponseEntity<User> changePassword(@PathVariable Long id, @RequestBody UserPasswordDto userPasswordDto){
        return ResponseEntity.ok().body(userService.changepasswor(id, userPasswordDto));
    }


 @GetMapping("/users/{id}")

      public User getUserById(@PathVariable Long id){
     return userService.findUserById(id);
     
    } 

}