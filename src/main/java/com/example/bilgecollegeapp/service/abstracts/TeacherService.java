package com.example.bilgecollegeapp.service.abstracts;

import com.example.bilgecollegeapp.model.dtos.student.StudentListResponse;
import com.example.bilgecollegeapp.model.dtos.teacher.TeacherAddRequest;
import com.example.bilgecollegeapp.model.dtos.teacher.TeacherAddResponse;
import com.example.bilgecollegeapp.model.dtos.teacher.TeacherListResponse;
import com.example.bilgecollegeapp.model.entity.Student;

import java.util.List;

public interface TeacherService {
    List<TeacherListResponse> getAll();

    TeacherAddResponse add(TeacherAddRequest request);

    List<StudentListResponse> myStudents();
}
