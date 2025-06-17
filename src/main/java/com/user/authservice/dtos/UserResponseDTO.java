package com.user.authservice.dtos;

public class UserResponseDTO {
    private String username;
    private String token;

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getToken() {
        return this.token;
    }
    public UserResponseDTO(){}
    public UserResponseDTO( String username,String token) {
        this.username = username;
        this.token = token;
    }
}
