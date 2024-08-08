package com.example.bilgecollegeapp.service.abstracts;

import com.example.bilgecollegeapp.model.dtos.grade.GradeListResponse;
import com.example.bilgecollegeapp.model.dtos.parent.*;
import com.example.bilgecollegeapp.model.dtos.student.StudentNotResponse;
import com.example.bilgecollegeapp.model.entity.Grade;

import java.util.List;

public interface ParentService {
    List<ParentListResponse> getAll();

    ParentAddResponse add(ParentAddRequest request);

    ParentUpdateResponse update(ParentUpdateRequest request);

    List<GradeListResponse> myStudentGrades();
}
