package com.example.bilgecollegeapp.repository;

import com.example.bilgecollegeapp.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
