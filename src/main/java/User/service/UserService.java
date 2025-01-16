package User.service;

import User.Repository.UserRepo;
import User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmailService emailService;

    @Transactional
    public User signUp(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String token = UUID.randomUUID().toString();
        user.setVerificationToken(token);
        userRepo.save(user);
        emailService.sendVerificationEmail(user.getUserEmail(), token);
        return user;
    }

    public void verifyUser(String token){
        User user = userRepo.findByVerificationToken(token)
                    .orElseThrow(() -> new RuntimeException("Invalid token"));
        user.setVerificationToken(null);
        userRepo.save(user);
    }
}
