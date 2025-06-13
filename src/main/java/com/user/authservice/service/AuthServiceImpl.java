package com.user.authservice.service;

import com.user.authservice.dtos.RegisterUserDTO;
import com.user.authservice.dtos.UserResponseDTO;
import com.user.authservice.exception.UserNotFoundException;
import com.user.authservice.models.User;
import com.user.authservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements IAuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public AuthServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
        this.userRepository=userRepository;
    }

    @Override
    public UserResponseDTO register(RegisterUserDTO request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserNotFoundException("Username already exists");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);

        return new UserResponseDTO(savedUser.getId(), savedUser.getUsername());
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getUsername()))
                .collect(Collectors.toList());
    }
}
