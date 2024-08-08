package com.example.bilgecollegeapp.service.abstracts;

import com.example.bilgecollegeapp.model.dtos.classroom.ClassroomAddRequest;
import com.example.bilgecollegeapp.model.dtos.classroom.ClassroomAddResponse;
import com.example.bilgecollegeapp.model.dtos.classroom.ClassroomListResponse;

import java.util.List;

public interface ClassroomService {
    List<ClassroomListResponse> getAll();

    ClassroomAddResponse add(ClassroomAddRequest request);
}
