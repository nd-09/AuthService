package com.user.authservice.dtos;

import lombok.Data;

@Data
public class LoginResponseDTO {
   public LoginResponseDTO(String token) {
      this.token = token;
   }

   private String token;

   public String getToken() {
      return token;
   }
}
