package com.project.medialytics.User.service;

import com.project.medialytics.User.Repository.UserRepo;
import com.project.medialytics.User.entity.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void signUp(@NotNull User user) {
        user.setUserEmail(user.getUserEmail());
        user.setPassword(user.getPassword());
        String token = UUID.randomUUID().toString();
        user.setVerificationToken(token);
        userRepo.save(user);
    }
}
