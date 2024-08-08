package com.example.bilgecollegeapp.repository;

import com.example.bilgecollegeapp.model.entity.Classroom;
import com.example.bilgecollegeapp.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
    Classroom findByMainTeacherId(long id);
    Classroom findByMainTeacherEmail(String email);



}
