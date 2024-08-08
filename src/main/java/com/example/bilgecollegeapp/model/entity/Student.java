package com.example.bilgecollegeapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends User{
 /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
    private String email;
    private String password;*/
    private int number;

    @OneToOne(mappedBy = "student")
    private Parent parent;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;



   @OneToMany(mappedBy = "student")
   private List<Certificate> certificates;
}
