package com.user.authservice.dtos;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getId() {
        return this.id;
    }
    public UserResponseDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
