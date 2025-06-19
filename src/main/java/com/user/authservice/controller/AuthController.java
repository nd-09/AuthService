package com.user.authservice.controller;

import com.user.authservice.dtos.LoginRequestDTO;
import com.user.authservice.dtos.RegisterUserDTO;
import com.user.authservice.dtos.UserResponseDTO;
import com.user.authservice.service.AuthServiceImpl;
import com.user.authservice.service.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final IAuthService authService;

    public AuthController(AuthServiceImpl authService){
        this.authService=authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO request) {
        UserResponseDTO response = authService.login(request);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterUserDTO request) {
        UserResponseDTO response = authService.register(request);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.ok(authService.getAllUsers());
    }
}
