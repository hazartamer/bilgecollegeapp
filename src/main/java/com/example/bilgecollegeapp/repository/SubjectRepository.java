package com.example.bilgecollegeapp.repository;

import com.example.bilgecollegeapp.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
