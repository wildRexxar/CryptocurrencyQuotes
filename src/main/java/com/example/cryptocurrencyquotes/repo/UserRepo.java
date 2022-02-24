package com.example.cryptocurrencyquotes.repo;

import com.example.cryptocurrencyquotes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean findByUsername(String username);
}
