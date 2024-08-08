package com.example.bilgecollegeapp.repository;

import com.example.bilgecollegeapp.model.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudentNumber(int number);
}
