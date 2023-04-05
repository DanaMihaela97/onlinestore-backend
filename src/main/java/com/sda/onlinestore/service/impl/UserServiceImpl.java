package com.sda.onlinestore.service.impl;

import com.sda.onlinestore.dto.UserDto;
import com.sda.onlinestore.entity.User;
import com.sda.onlinestore.repository.UserRepository;
import com.sda.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void updateUserDetails(User user) {
        User userDB = userRepository.findById(user.getId()).get();
        userDB.setName(user.getName());
        userDB.setEmail(user.getEmail());

        userRepository.save(userDB);

    }

}