package com.user.authservice.dtos;

import com.user.authservice.dtos.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticateTokenResponseDto {
    public AuthenticateTokenResponseDto tokenVerificationStatus;
    public ResponseStatus ResponseStatus;
}
