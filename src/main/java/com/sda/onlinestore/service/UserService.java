package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.UserCreateDto;
import com.sda.onlinestore.dto.UserInfoDto;

import java.util.List;


public interface UserService {

    UserInfoDto createUser(UserCreateDto userCreateDto, Integer id);
    List<UserInfoDto> getAllUsers();
    UserInfoDto getUserById(Integer id);
    void editDetails(Integer id, String name, String email, String city, String avatar,
                     String phoneNumber);

}
