package User.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


//@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @NotNull
    private String userName;

    @Email
    private String userEmail;

    @NotNull
    private String password;

    private String verificationToken;

    private AppUserRole userRole;

    public User(long userId, String userName, String userEmail, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

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

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public void setUserRole(AppUserRole userRole) {
        this.userRole = userRole;
    }

    public @NotNull String getUserName() {
        return userName;
    }

    public @Email String getUserEmail() {
        return userEmail;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public AppUserRole getUserRole() {
        return userRole;
    }
}
