package com.example.bilgecollegeapp.service.dtos.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectAddResponse {
    private String name;
    private String description;
}
