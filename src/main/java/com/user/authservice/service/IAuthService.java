package com.user.authservice.service;


import com.user.authservice.dtos.RegisterUserDTO;
import com.user.authservice.dtos.UserResponseDTO;

import java.util.List;

public interface IAuthService {
    UserResponseDTO register(RegisterUserDTO request);
    List<UserResponseDTO> getAllUsers();
}