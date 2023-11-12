package com.springboot.springbootusertodo.service;

import com.springboot.springbootusertodo.model.AppUser;
import com.springboot.springbootusertodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public AppUser login(AppUser user) {
        AppUser loginUser = userRepository.findUser(user.getUsername(), user.getPassword());
        return loginUser;
    }

    public AppUser register(AppUser user) {
        userRepository.save(user);
        return user;
    }
}
