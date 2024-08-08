package com.example.bilgecollegeapp.repository;

import com.example.bilgecollegeapp.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByClassroomId(long id);
    Student findByNumber(int number);

    Student findByEmail(String email);
}
