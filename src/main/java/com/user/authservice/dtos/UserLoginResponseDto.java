package com.user.authservice.dtos;

import com.user.authservice.dtos.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponseDto {
    private String tokenValue;
    private ResponseStatus responseStatus;
}
