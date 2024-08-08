package com.example.bilgecollegeapp.service.abstracts;

import com.example.bilgecollegeapp.model.dtos.subject.SubjectAddRequest;
import com.example.bilgecollegeapp.model.dtos.subject.SubjectAddResponse;
import com.example.bilgecollegeapp.model.dtos.subject.SubjectListResponse;

import java.util.List;

public interface SubjectService {
    List<SubjectListResponse> getAll();

    SubjectAddResponse add(SubjectAddRequest request);
}
