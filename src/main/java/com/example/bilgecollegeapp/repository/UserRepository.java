package com.example.bilgecollegeapp.repository;

import com.example.bilgecollegeapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
