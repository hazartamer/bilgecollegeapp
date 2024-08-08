package com.example.bilgecollegeapp.model.dtos.grade;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GradeUpdateResponse {
    private double grade;
    private int studentNumber;
    private long subjectId;
}
