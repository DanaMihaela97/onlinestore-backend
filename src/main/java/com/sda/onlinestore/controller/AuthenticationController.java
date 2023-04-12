package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.AuthenticationRequest;
import com.sda.onlinestore.dto.AuthenticationResponse;
import com.sda.onlinestore.dto.RegisterRequest;
import com.sda.onlinestore.service.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/onlinestore")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
