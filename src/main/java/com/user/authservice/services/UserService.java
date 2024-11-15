package com.user.authservice.services;

import com.user.authservice.repositories.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepositiry userRepository;


}
