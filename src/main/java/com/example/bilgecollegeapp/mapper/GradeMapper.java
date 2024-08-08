package com.example.bilgecollegeapp.mapper;

import com.example.bilgecollegeapp.model.dtos.grade.GradeAddRequest;
import com.example.bilgecollegeapp.model.dtos.grade.GradeAddResponse;
import com.example.bilgecollegeapp.model.entity.Grade;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface GradeMapper {

    GradeMapper INSTANCE = Mappers.getMapper(GradeMapper.class);

    @Mapping(target = "student.number", source = "studentNumber")
    @Mapping(target = "subject.Id", source = "subjectId")
    Grade rRequestMapper(GradeAddRequest request);

    @Mapping(target = "student.number", source = "studentNumber")
    @Mapping(target = "subject.Id", source = "subjectId")
    GradeAddResponse rResponseMapper(Grade grade);
}
