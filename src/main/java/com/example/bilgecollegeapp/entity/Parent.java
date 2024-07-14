package com.example.bilgecollegeapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parent {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @OneToOne()
    @JoinColumn(name = "student_id")
    private Student student;
}
