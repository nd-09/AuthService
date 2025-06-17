package com.user.authservice.dtos;

import lombok.Data;

@Data
public class LoginResponseDTO {
   public LoginResponseDTO(String token) {
      this.token = token;
   }
   private String username;
   private String token;

   public String getToken() {
      return this.token;
   }
   public void setToken(String token) {
      this.token = token;
   }
   public String getUsername() {
      return this.username;
   }
   public void setUsername(String username) {
      this.username = username;
   }
}
