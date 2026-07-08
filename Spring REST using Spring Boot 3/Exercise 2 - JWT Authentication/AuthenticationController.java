package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.AuthenticationResponse;
import com.cognizant.springlearn.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate() {

        JwtUtil jwtUtil = new JwtUtil();

        String token = jwtUtil.generateToken("user");

        return new AuthenticationResponse(token);
    }
}