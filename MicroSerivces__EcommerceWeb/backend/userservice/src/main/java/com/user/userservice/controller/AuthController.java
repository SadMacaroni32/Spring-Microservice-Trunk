package com.user.userservice.controller;

import com.user.userservice.DTO.UserDTO;
import com.user.userservice.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestParam String username, @RequestParam String password) {
        
        
        // Generate JWT token
        String token = jwtUtil.generateToken(username);

        // Return the response with the token only
        return ResponseEntity.ok(new UserDTO(token));
    }
}
