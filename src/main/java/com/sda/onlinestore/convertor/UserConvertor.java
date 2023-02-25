package com.sda.onlinestore.convertor;

import com.sda.onlinestore.dto.UserDto;
import com.sda.onlinestore.entity.User;

public class UserConvertor {

    public static UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

}
