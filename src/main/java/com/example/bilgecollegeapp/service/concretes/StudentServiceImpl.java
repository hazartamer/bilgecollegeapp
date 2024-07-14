package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.entity.Student;
import com.example.bilgecollegeapp.repository.StudentRepository;
import com.example.bilgecollegeapp.service.dtos.student.StudentAddRequest;
import com.example.bilgecollegeapp.service.dtos.student.StudentAddResponse;
import com.example.bilgecollegeapp.service.dtos.student.StudentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl {
    private final StudentRepository repository;

    public List<StudentListResponse> getAll(){
        List<Student> all = repository.findAll();
        return all.stream().map(r ->new StudentListResponse(r.getFirstName(),r.getLastName())).toList();
    }

    public StudentAddResponse add(StudentAddRequest request){
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        repository.save(student);
        return new StudentAddResponse(student.getFirstName(),student.getLastName());
    }
}
