package com.example.bilgecollegeapp.service.dtos.parent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParentAddResponse {
    private String firstName;
    private String lastName;
    private String studentName;
}
