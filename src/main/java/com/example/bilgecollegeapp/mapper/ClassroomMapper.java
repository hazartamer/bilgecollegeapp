package com.example.bilgecollegeapp.mapper;

import com.example.bilgecollegeapp.entity.Classroom;
import com.example.bilgecollegeapp.service.dtos.classroom.ClassroomAddRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassroomMapper {
    ClassroomMapper INSTANCE = Mappers.getMapper(ClassroomMapper.class);

}
