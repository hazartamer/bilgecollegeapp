package com.example.bilgecollegeapp.controller;

import com.example.bilgecollegeapp.service.concretes.ParentServiceImpl;
import com.example.bilgecollegeapp.service.dtos.parent.ParentListResponse;
import com.example.bilgecollegeapp.service.dtos.parent.ParentAddRequest;
import com.example.bilgecollegeapp.service.dtos.parent.ParentAddResponse;
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
}
