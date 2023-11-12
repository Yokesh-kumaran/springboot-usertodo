package com.springboot.springbootusertodo.controller;

import com.springboot.springbootusertodo.model.AppUser;
import com.springboot.springbootusertodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public AppUser login(@RequestBody AppUser user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser user) {
        return userService.register(user);
    }
}
