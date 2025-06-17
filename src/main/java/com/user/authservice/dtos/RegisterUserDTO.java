package com.user.authservice.dtos;

import lombok.Data;

@Data
public class RegisterUserDTO {
    private String username;
    private String password;
    private String role;

    public String getUsername() {
     return this.username;
    }
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole() {
        return this.role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
