package com.example.bilgecollegeapp.model.dtos.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentNotResponse {
    private String subjectName;
    private double grade;

}
