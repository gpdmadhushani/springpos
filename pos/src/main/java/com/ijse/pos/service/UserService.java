package com.ijse.pos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos.dto.UserPasswordDto;
import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.User;

@Service
public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(Long id);
    User changepasswor(Long id, UserPasswordDto userPasswordDto);
    User findUserById(Long id);
}
