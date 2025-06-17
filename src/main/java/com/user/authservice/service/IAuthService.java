package com.user.authservice.service;


import com.user.authservice.dtos.LoginRequestDTO;
import com.user.authservice.dtos.LoginResponseDTO;
import com.user.authservice.dtos.RegisterUserDTO;
import com.user.authservice.dtos.UserResponseDTO;

import java.util.List;

public interface IAuthService {
    UserResponseDTO register(RegisterUserDTO request);
    UserResponseDTO login(LoginRequestDTO request);
    List<UserResponseDTO> getAllUsers();
}