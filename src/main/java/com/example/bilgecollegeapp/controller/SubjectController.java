package com.example.bilgecollegeapp.controller;

import com.example.bilgecollegeapp.service.concretes.SubjectServiceImpl;
import com.example.bilgecollegeapp.service.dtos.subject.SubjectAddRequest;
import com.example.bilgecollegeapp.service.dtos.subject.SubjectAddResponse;
import com.example.bilgecollegeapp.service.dtos.subject.SubjectListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SubjectListResponse> getAll(){
        return service.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectAddResponse add(SubjectAddRequest request){
        return service.add(request);
    }
}
