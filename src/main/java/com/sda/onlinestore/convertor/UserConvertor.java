package com.sda.onlinestore.convertor;

import com.sda.onlinestore.dto.UserCreateDto;
import com.sda.onlinestore.dto.UserInfoDto;
import com.sda.onlinestore.entity.User;

public class UserConvertor {

    public static User toEntity(UserCreateDto userCreateDto, Integer id){
        User user = new User();
        user.setEmail(userCreateDto.getEmail());
        user.setName(userCreateDto.getName());
        user.setPhoneNumber(userCreateDto.getPhoneNumber());
        user.setCity(userCreateDto.getCity());
        user.setAvatar(userCreateDto.getAvatar());
        user.setId(id);
        user.setPassword(userCreateDto.getPassword());


        return user;
    }
    public static User toEntity(UserInfoDto userInfoDto){
        User user = new User();
        user.setEmail(userInfoDto.getEmail());
        user.setName(userInfoDto.getName());
        user.setPhoneNumber(userInfoDto.getPhoneNumber());
        user.setCity(userInfoDto.getCity());
        user.setId(userInfoDto.getId());
        user.setPassword(userInfoDto.getPassword());

        return user;
    }
    public static UserInfoDto entityToInfo(User user){
        UserInfoDto userInfoDto=new UserInfoDto();
        userInfoDto.setId(user.getId());
        userInfoDto.setName(user.getName());
        userInfoDto.setEmail(user.getEmail());
        userInfoDto.setPhoneNumber(user.getPhoneNumber());
        userInfoDto.setCity(user.getCity());


        return userInfoDto;
    }
}
