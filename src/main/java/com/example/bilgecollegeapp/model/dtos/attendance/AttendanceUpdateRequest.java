package com.example.bilgecollegeapp.model.dtos.attendance;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttendanceUpdateRequest {
    private long id;
    private int studentNumber;
    private LocalDate date;
    private boolean present;
}
