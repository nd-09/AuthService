package com.user.authservice.dtos;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String username;
    private String password;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

}
