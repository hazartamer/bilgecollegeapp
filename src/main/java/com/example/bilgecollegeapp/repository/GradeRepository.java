package com.example.bilgecollegeapp.repository;

import com.example.bilgecollegeapp.model.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentId(long id);
    Grade findByStudentIdAndSubjectId(long stuId, long subId);
}
