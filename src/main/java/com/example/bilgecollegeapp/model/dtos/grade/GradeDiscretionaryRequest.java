package com.example.bilgecollegeapp.model.dtos.grade;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GradeDiscretionaryRequest {
    private double discretionaryGrade;
    private int studentNumber;
}
