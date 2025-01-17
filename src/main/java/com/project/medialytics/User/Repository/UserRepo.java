package com.project.medialytics.User.Repository;

import com.project.medialytics.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

}
