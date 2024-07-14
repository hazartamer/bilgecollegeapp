package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.entity.Parent;
import com.example.bilgecollegeapp.entity.Student;
import com.example.bilgecollegeapp.mapper.ParentMapper;
import com.example.bilgecollegeapp.repository.ParentRepository;
import com.example.bilgecollegeapp.repository.StudentRepository;
import com.example.bilgecollegeapp.service.dtos.parent.ParentAddRequest;
import com.example.bilgecollegeapp.service.dtos.parent.ParentAddResponse;
import com.example.bilgecollegeapp.service.dtos.parent.ParentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl {
    private final ParentRepository parentRepository;
    private final StudentRepository studentRepository;

    public List<ParentListResponse> getAll(){
        List<Parent> parents = parentRepository.findAll();
       return parents.stream().map(r -> new ParentListResponse(r.getFirstName(),r.getLastName())).toList();
    }

    public ParentAddResponse add(ParentAddRequest request){
        Student student = studentRepository.findById(request.getStudentId()).orElseThrow();
        Parent parent = ParentMapper.INSTANCE.pRequestMapper(request);
        parent.setStudent(student);
        parentRepository.save(parent);
        ParentAddResponse parentAddResponse = ParentMapper.INSTANCE.pResponseMapper(parent);
        return parentAddResponse;
    }
}
