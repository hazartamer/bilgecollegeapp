package com.example.bilgecollegeapp.service.abstracts;

import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceAddRequest;
import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceAddResponse;
import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceUpdateRequest;
import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceUpdateResponse;

public interface AttendanceService {
    AttendanceAddResponse add(AttendanceAddRequest request);

    AttendanceUpdateResponse update(AttendanceUpdateRequest request);
}
