package com.example.bilgecollegeapp.model.dtos.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherAddRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthdate;
}
