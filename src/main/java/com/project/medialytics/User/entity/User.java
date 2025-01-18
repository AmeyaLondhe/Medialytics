package com.project.medialytics.User.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false)
    @NotNull
    private String userName;

    @Column(unique = true, length = 100, nullable = false)
    @Email
    private String userEmail;

    @Column(nullable = false)
    @NotNull
    private String password;

    @Setter
    private String verificationToken;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(@NotNull String userName) {
        this.userName = userName;
    }

    public void setUserEmail(@Email String userEmail) {
        this.userEmail = userEmail;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    @Override
    public @NotNull String getPassword() {
        return password;
    }

    public @Email String getUserEmail() {
        return userEmail;
    }

    public @NotNull String getUserName() {
        return userName;
    }

    public long getUserId() {
        return userId;
    }

    @Setter
    private AppUserRole userRole;

    public User() {
    }

    public User(long userId, String userName, String userEmail, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
    }

    //returns the user’s roles list; it is helpful to manage permissions.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    //returns the email address because it is unique information about the user.
    @Override
    public String getUsername() {
        return "";
    }


//    public AppUserRole getUserRole() {
//        return userRole;
//    }
}
