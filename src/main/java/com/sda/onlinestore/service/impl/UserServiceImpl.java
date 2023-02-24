package com.sda.onlinestore.service.impl;

import com.sda.onlinestore.convertor.UserConvertor;
import com.sda.onlinestore.dto.UserCreateDto;
import com.sda.onlinestore.dto.UserInfoDto;

import com.sda.onlinestore.entity.User;
import com.sda.onlinestore.repository.UserRepository;
import com.sda.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserInfoDto createUser(UserCreateDto userCreateDto, Integer id) {
       User user = userRepository.save(UserConvertor.toEntity(userCreateDto, id));
       UserInfoDto userInfoDto=UserConvertor.entityToInfo(user);

       return userInfoDto;
    }

    @Override
    public List<UserInfoDto> getAllUsers() {
        List<User> infoDtoList =  userRepository.findAll();
        return infoDtoList.stream().map(UserConvertor::entityToInfo).toList();
    }

    @Override
    public UserInfoDto getUserById(Integer id) {
        return UserConvertor.entityToInfo(userRepository.findById(id).get());
    }

    @Override
    public void editDetails(Integer id,String name, String email, String city, String avatar, String phoneNumber) {
        User user = userRepository.findById(id).get();
        user.setName(name);
        user.setEmail(email);
        user.setCity(city);
        user.setAvatar(avatar);
        user.setPhoneNumber(phoneNumber);

        userRepository.save(user);
    }

}
