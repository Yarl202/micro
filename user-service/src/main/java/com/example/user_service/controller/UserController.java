package com.example.user_service.controller;

import com.example.user_service.code.User;
import com.example.user_service.code.UserDto;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public void saveUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        userService.saveOrUpdateUser(userDto);
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.findByUserName(username);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
}
