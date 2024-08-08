package com.example.bilgecollegeapp.model.dtos.parent;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParentUpdateResponse {
    private String email;
    private String firstName;
    private String lastName;
    private String studentName;
}
