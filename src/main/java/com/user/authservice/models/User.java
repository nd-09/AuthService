package com.user.authservice.models;

import com.user.authservice.models.Enums.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class User extends BaseModel {
    private long id;
    private String username;
    private String hashedPassword;
    private String email;

    @Enumerated
    @ManyToMany
    private List<Role> roles;
    private UserStatus status;

}
