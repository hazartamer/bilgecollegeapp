package com.example.bilgecollegeapp.service.dtos.classroom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomAddRequest {
    private String name;
    private long mainTeacherId;
}
