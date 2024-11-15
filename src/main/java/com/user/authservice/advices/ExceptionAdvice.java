package com.user.authservice.advices;

import com.user.authservice.Exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionAdvice{
public ResponseEntity<UserNotFoundException> handleUserNotFoundException(Long id){
    UserNotFoundException exp = new UserNotFoundException();
    exp.setMessage("User with id "+id+" Not found");
    return new ResponseEntity<>(exp, HttpStatus.NOT_FOUND);
}
}
