package com.project.medialytics.User.controller;

import com.project.medialytics.User.entity.User;
import com.project.medialytics.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    UserService userService;


    @GetMapping("/")
    public void signUp(User user){
        userService.signUp(user);
    }
}
