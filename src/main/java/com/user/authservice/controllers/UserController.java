package com.user.authservice.controllers;


import com.user.authservice.dtos.*;
import com.user.authservice.models.User;
import com.user.authservice.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public UserLoginResponseDto userLogin(String username, String password) {
        return new UserLoginResponseDto();
    }
    @PostMapping("/logout")
    private void userLogOut(@RequestBody User userRequestDto){

    }

    @PostMapping("/signup")
    public UserSignupResponseDto userSignUp(@RequestBody UserSignupRequestDto userSignUpRequestDto){
    return null;
    }


    @PostMapping("/login")
    public UserLoginResponseDto userSignUp(@RequestBody UserLoginRequestDto userLoginRequestDto){
        return null;
    }

    @PostMapping("/authenticate")
    public AuthenticateTokenResponseDto validateToken(String token, @RequestBody AuthenticateTokenRequestDto authenticateTokenRequestDto){
     return null;
    }

}
