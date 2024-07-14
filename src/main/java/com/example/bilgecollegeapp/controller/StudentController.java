package com.example.bilgecollegeapp.controller;


import com.example.bilgecollegeapp.service.concretes.StudentServiceImpl;
import com.example.bilgecollegeapp.service.dtos.student.StudentAddRequest;
import com.example.bilgecollegeapp.service.dtos.student.StudentAddResponse;
import com.example.bilgecollegeapp.service.dtos.student.StudentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentListResponse> getAll(){
        return service.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentAddResponse response(StudentAddRequest request){
        return service.add(request);
    }
}
