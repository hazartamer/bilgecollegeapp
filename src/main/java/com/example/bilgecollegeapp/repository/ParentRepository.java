package com.example.bilgecollegeapp.repository;

import com.example.bilgecollegeapp.model.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    Parent findByEmail(String email);
    Parent findByStudentId(long id);
}
