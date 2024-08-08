package com.example.bilgecollegeapp.model.dtos.parent;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParentUpdateRequest {
    private long id;
    private String email;
    private String firstName;
    private String lastName;

}
