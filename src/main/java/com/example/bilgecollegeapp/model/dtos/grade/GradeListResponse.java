package com.example.bilgecollegeapp.model.dtos.grade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradeListResponse {
    private String subjectName;
    private double grade;
}
