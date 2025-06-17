package com.user.authservice.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String role;

    private String token;

    public String getUsername() {
        return this.username;
    }
   public Long getId() {
        return this.id;
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
   public void setRole(String role) {
        this.role = role;
   }

   public String getRole() {
        return this.role;
   }

   public String getToken() {
        return this.token;
   }
   public void setToken(String token) {
        this.token = token;
   }

}

