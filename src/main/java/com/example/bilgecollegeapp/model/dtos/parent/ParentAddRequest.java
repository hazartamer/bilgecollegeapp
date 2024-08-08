package com.example.bilgecollegeapp.model.dtos.parent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParentAddRequest {
    private String firstName;
    private String lastName;
    private long studentId;
}
