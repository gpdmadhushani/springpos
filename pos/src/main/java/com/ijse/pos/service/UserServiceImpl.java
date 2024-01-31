package com.ijse.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos.dto.UserPasswordDto;
import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.User;
import com.ijse.pos.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User changepasswor(Long id, UserPasswordDto userPasswordDto) {
        User user=userRepository.findById(id).orElse(null);
        if(user!=null){
            user.setPassword(userPasswordDto.getPassword());
            return userRepository.save(user);
        }else{
            return null;
        }
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
