package com.example.bilgecollegeapp.repository;


import com.example.bilgecollegeapp.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
