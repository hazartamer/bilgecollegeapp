package com.example.bilgecollegeapp.repository;

import com.example.bilgecollegeapp.model.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate,Long> {
}
