package com.user.authservice.dtos;

import com.user.authservice.dtos.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLogoutResponseDto {
    public boolean tokenExpired;
    public ResponseStatus responseStatus;
}
