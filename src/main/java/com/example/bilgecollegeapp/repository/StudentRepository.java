package com.example.bilgecollegeapp.repository;

import com.example.bilgecollegeapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
