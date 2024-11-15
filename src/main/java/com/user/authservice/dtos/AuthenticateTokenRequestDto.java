package com.user.authservice.dtos;

import com.user.authservice.models.User;



public class AuthenticateTokenRequestDto {
    private User user;
    private String tokenValue;
}
