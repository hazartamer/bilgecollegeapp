package com.example.bilgecollegeapp.model.dtos.grade;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GradeUpdateRequest {
    private int studentNumber;
    private double grade1;
    private double discretionaryGrade;
    private double grade2;
}
