package com.example.bilgecollegeapp.mapper;


import com.example.bilgecollegeapp.model.dtos.teacher.TeacherAddRequest;
import com.example.bilgecollegeapp.model.dtos.teacher.TeacherAddResponse;
import com.example.bilgecollegeapp.model.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher tRequestMapper(TeacherAddRequest request);

    TeacherAddResponse tResponseMapper(Teacher teacher);
}
