package com.example.bilgecollegeapp.controller;

import com.example.bilgecollegeapp.model.dtos.grade.GradeListResponse;
import com.example.bilgecollegeapp.model.dtos.parent.*;
import com.example.bilgecollegeapp.model.dtos.student.StudentNotResponse;
import com.example.bilgecollegeapp.model.entity.Grade;
import com.example.bilgecollegeapp.service.concretes.ParentServiceImpl;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentServiceImpl parentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ParentListResponse> getAll(){
       return parentService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParentAddResponse add(ParentAddRequest request){
       return parentService.add(request);
    }

    @GetMapping("/grades")
    @ResponseStatus(HttpStatus.OK)
    public List<GradeListResponse> myStudentGrades(){
        return parentService.myStudentGrades();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ParentUpdateResponse update(ParentUpdateRequest request){
        return parentService.update(request);
    }
}
