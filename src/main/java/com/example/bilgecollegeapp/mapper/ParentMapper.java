package com.example.bilgecollegeapp.mapper;

import com.example.bilgecollegeapp.entity.Parent;
import com.example.bilgecollegeapp.service.dtos.parent.ParentAddRequest;
import com.example.bilgecollegeapp.service.dtos.parent.ParentAddResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParentMapper {
    ParentMapper INSTANCE = Mappers.getMapper(ParentMapper.class);

    @Mapping(target = "student.id" ,source = "studentId")
    Parent pRequestMapper(ParentAddRequest request);

    @Mapping(target = "studentName", source = "student.firstName")
    ParentAddResponse pResponseMapper(Parent parent);
}
