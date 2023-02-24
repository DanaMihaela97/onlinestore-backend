package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.UserCreateDto;
import com.sda.onlinestore.dto.UserInfoDto;
import com.sda.onlinestore.entity.User;
import com.sda.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/onlinestore")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserInfoDto> createUser(@PathVariable String id, @RequestBody UserCreateDto userCreateDto){
        UserInfoDto userInfoDto = userService.createUser(userCreateDto, Integer.valueOf(id));

        return ResponseEntity.ok(userInfoDto);
    }
//    @PutMapping("/users/{id}")
//    public ResponseEntity<String> editDetails(@PathVariable Integer id, @RequestBody User user ){
//        userService.editDetails(id, user.getName(), user.getEmail(), user.getCity(), user.getAvatar(), user.getPhoneNumber());
//
//        return ResponseEntity.ok("Details updated!");
//
//    }

    @GetMapping("/users")
    public ResponseEntity<List<UserInfoDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
