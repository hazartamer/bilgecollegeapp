package com.example.bilgecollegeapp.model.dtos.grade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradeAddRequest {
    private double grade1;
    private int studentNumber;
    //private long subjectId;
}
