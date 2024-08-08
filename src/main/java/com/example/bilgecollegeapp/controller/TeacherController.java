package com.example.bilgecollegeapp.controller;

import com.example.bilgecollegeapp.model.dtos.student.StudentListResponse;
import com.example.bilgecollegeapp.model.entity.Student;
import com.example.bilgecollegeapp.service.concretes.TeacherServiceImpl;
import com.example.bilgecollegeapp.model.dtos.teacher.TeacherAddRequest;
import com.example.bilgecollegeapp.model.dtos.teacher.TeacherAddResponse;
import com.example.bilgecollegeapp.model.dtos.teacher.TeacherListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherServiceImpl teacherService;

    @GetMapping("getAll")
    @ResponseStatus(HttpStatus.OK)
    private List<TeacherListResponse> getAll(){
        return teacherService.getAll();
    }

    @PostMapping("addTeacher")
    @ResponseStatus(HttpStatus.CREATED)
    private TeacherAddResponse add(@RequestBody TeacherAddRequest request){
        return teacherService.add(request);
    }

    @GetMapping("myStudents")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentListResponse> myStudents(){
        return teacherService.myStudents();
    }
}
