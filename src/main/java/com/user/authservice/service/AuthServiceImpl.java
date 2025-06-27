package com.user.authservice.service;

import com.user.authservice.dtos.LoginRequestDTO;
import com.user.authservice.dtos.RegisterUserDTO;
import com.user.authservice.dtos.UserResponseDTO;
import com.user.authservice.exception.UserNotFoundException;
import com.user.authservice.models.User;
import com.user.authservice.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements IAuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    public AuthServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager,JwtService jwtService){
        this.passwordEncoder=passwordEncoder;
        this.authenticationManager=authenticationManager;
        this.userRepository=userRepository;
        this.jwtService=jwtService;
    }

    public UserResponseDTO login(LoginRequestDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtService.generateToken(user);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setToken(token);
        userResponseDTO.setRole(user.getRole());
        userResponseDTO.setUsername(user.getUsername());
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO register(RegisterUserDTO request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserNotFoundException("Username already exists");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setRole(request.getRole().toUpperCase());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.saveAndFlush(user);

        String token = jwtService.generateToken(savedUser);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUsername(savedUser.getUsername());
        userResponseDTO.setToken(token);

        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponseDTO(user.getUsername(), user.getToken()))
                .collect(Collectors.toList());
    }
}
