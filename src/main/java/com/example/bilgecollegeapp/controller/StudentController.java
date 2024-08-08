package com.example.bilgecollegeapp.controller;


import com.example.bilgecollegeapp.model.dtos.student.StudentNotResponse;
import com.example.bilgecollegeapp.service.concretes.StudentServiceImpl;
import com.example.bilgecollegeapp.model.dtos.student.StudentAddRequest;
import com.example.bilgecollegeapp.model.dtos.student.StudentAddResponse;
import com.example.bilgecollegeapp.model.dtos.student.StudentListResponse;
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

    @GetMapping("getMyStudents")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentListResponse> getTeacherById(){
        return service.getTeacherById();
    }

    @GetMapping("myNots")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentNotResponse> myNots(){
        return service.myNots();
    }
}
