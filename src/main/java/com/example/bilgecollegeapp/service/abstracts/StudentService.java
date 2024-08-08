package com.example.bilgecollegeapp.service.abstracts;

import com.example.bilgecollegeapp.model.dtos.student.StudentAddRequest;
import com.example.bilgecollegeapp.model.dtos.student.StudentAddResponse;
import com.example.bilgecollegeapp.model.dtos.student.StudentListResponse;
import com.example.bilgecollegeapp.model.dtos.student.StudentNotResponse;

import java.util.List;

public interface StudentService {
    List<StudentListResponse> getAll();

    StudentAddResponse add(StudentAddRequest request);

    List<StudentListResponse> getTeacherById();

    List<StudentNotResponse> myNots();
}
