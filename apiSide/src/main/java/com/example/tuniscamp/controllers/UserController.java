package com.example.tuniscamp.controllers;

import com.example.tuniscamp.entities.User;
import com.example.tuniscamp.exception.EmailExistException;
import com.example.tuniscamp.exception.ExceptionHandling;
import com.example.tuniscamp.exception.UserNotFoundException;
import com.example.tuniscamp.exception.UsernameExistException;
import com.example.tuniscamp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/user"})
public class UserController extends ExceptionHandling {
    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String showUser() throws EmailExistException{
        //return "appl works";
        throw new EmailExistException("this email address is already taken");
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws UserNotFoundException, UsernameExistException, EmailExistException {
        User newUser = userService.register(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail());
        return new ResponseEntity<>(newUser, OK);
    }
}
