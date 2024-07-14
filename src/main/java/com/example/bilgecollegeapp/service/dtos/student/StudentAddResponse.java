package com.example.bilgecollegeapp.service.dtos.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentAddResponse {
    private String firstName;
    private String lastName;
}
