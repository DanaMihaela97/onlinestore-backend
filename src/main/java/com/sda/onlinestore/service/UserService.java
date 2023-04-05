package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.UserDto;
import com.sda.onlinestore.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    //void saveUser(UserDto userDto);
//    UserDto getUser(Long id);
    User findByEmail(String email);
    //List <UserDto> findAllUsers();
    User findById(Long id);

    void updateUserDetails(User user);

}