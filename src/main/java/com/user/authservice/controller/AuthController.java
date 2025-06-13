package com.user.authservice.controller;

import com.user.authservice.dtos.LoginRequestDTO;
import com.user.authservice.dtos.LoginResponseDTO;
import com.user.authservice.dtos.RegisterUserDTO;
import com.user.authservice.dtos.UserResponseDTO;
import com.user.authservice.service.AuthServiceImpl;
import com.user.authservice.service.IAuthService;
import com.user.authservice.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final IAuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthServiceImpl authService, AuthenticationManager authenticationManager, JwtService jwtService){
        this.authService=authService;
        this.jwtService=jwtService;
        this.authenticationManager=authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        String token= jwtService.generateToken(request.getUsername());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterUserDTO request) {
        System.out.println("Reaching here?"+request);
        UserResponseDTO response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.ok(authService.getAllUsers());
    }
}
