package com.sourav.springbootrestjob.Repository;

import com.sourav.springbootrestjob.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
}
