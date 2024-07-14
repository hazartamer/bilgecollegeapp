package com.example.bilgecollegeapp.controller;

import com.example.bilgecollegeapp.service.concretes.ClassroomServiceImpl;
import com.example.bilgecollegeapp.service.dtos.classroom.ClassroomAddRequest;
import com.example.bilgecollegeapp.service.dtos.classroom.ClassroomAddResponse;
import com.example.bilgecollegeapp.service.dtos.classroom.ClassroomListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
@RequiredArgsConstructor
public class ClassroomController {
    private final ClassroomServiceImpl service;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClassroomListResponse> getAll(){
        return service.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClassroomAddResponse response(ClassroomAddRequest request){
        return service.add(request);
    }
}
