package com.example.bilgecollegeapp.mapper;

import com.example.bilgecollegeapp.model.dtos.student.StudentAddRequest;
import com.example.bilgecollegeapp.model.dtos.student.StudentAddResponse;
import com.example.bilgecollegeapp.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student sRequestMapper(StudentAddRequest request);

    StudentAddResponse sResponseMapper(Student student);
}
