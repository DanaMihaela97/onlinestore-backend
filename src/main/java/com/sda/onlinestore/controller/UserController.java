package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.LoginRequest;
import com.sda.onlinestore.dto.LoginResponse;
import com.sda.onlinestore.dto.UserDto;
import com.sda.onlinestore.entity.User;
import com.sda.onlinestore.exception.ex.OrderException;
import com.sda.onlinestore.security.UserDetailImpl;
import com.sda.onlinestore.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/onlinestore")
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;

        this.authenticationManager = authenticationManager;
    }
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/findUsers")
    public ResponseEntity<List<UserDto>> findAllUsers()
    {
        List<UserDto> users = userService.findAllUsers();

        return ResponseEntity.ok(users);
    }
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto>findUser(@PathVariable Long id)
    {
        UserDto user = userService.getUser(id);
        return ResponseEntity.ok().body(user);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserDto userDto)
    {
        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null)
        {
            throw new OrderException.UserAlreadyTakenException("Email is already in use");
        }
        userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
//    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")

    @PostMapping("/signIn")
    public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority()).toList();

        LoginResponse response = new LoginResponse();
        response.setFullName(userDetails.getUserNameInfo());// aici intoarcem USERNAME
        response.setEmail(userDetails.getUsername()); // intoarce EMAIL in loc de USERNAME!!!
        response.setRole(String.join(" ", roles));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }




//    @PutMapping("/users/{id}")
//    public ResponseEntity<UserInfoDto> createUser(@PathVariable String id, @RequestBody UserCreateDto userCreateDto){
//        UserInfoDto userInfoDto = userService.createUser(userCreateDto, Integer.valueOf(id));
//
//        return ResponseEntity.ok(userInfoDto);
//    }
////    @PutMapping("/users/{id}")
////    public ResponseEntity<String> editDetails(@PathVariable Integer id, @RequestBody User user ){
////        userService.editDetails(id, user.getName(), user.getEmail(), user.getCity(), user.getAvatar(), user.getPhoneNumber());
////
////        return ResponseEntity.ok("Details updated!");
////
////    }
//
//    @GetMapping("/users")
//    public ResponseEntity<List<UserInfoDto>> getAllUsers(){
//        return ResponseEntity.ok(userService.getAllUsers());
//    }
}
