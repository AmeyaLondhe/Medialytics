package com.project.medialytics.User.service;

import com.project.medialytics.User.Dto.LoginDto;
import com.project.medialytics.User.Dto.RegisterDto;
import com.project.medialytics.User.Repository.UserRepo;
import com.project.medialytics.User.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepo userRepo,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterDto input) {
        User user = new User();
        user.setUserName(input.getUserName());
        user.setUserEmail(input.getUserEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepo.save(user);
    }

    public User authenticate(LoginDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUserEmail(),
                        input.getPassword()
                )
        );

        return userRepo.findByUserEmail(input.getUserEmail())
                .orElseThrow();
    }
}
