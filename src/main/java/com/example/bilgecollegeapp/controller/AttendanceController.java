package com.example.bilgecollegeapp.controller;

import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceAddRequest;
import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceAddResponse;
import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceUpdateRequest;
import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceUpdateResponse;
import com.example.bilgecollegeapp.service.abstracts.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AttendanceAddResponse add(AttendanceAddRequest request){
        return attendanceService.add(request);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AttendanceUpdateResponse update(AttendanceUpdateRequest request){
        return attendanceService.update(request);
    }

}
