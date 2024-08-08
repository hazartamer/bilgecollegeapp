package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.core.exceptionhandling.exception.BusinessException;
import com.example.bilgecollegeapp.model.dtos.grade.GradeListResponse;
import com.example.bilgecollegeapp.model.dtos.parent.*;
import com.example.bilgecollegeapp.model.entity.Grade;
import com.example.bilgecollegeapp.model.entity.Parent;
import com.example.bilgecollegeapp.model.entity.Student;
import com.example.bilgecollegeapp.mapper.ParentMapper;
import com.example.bilgecollegeapp.repository.GradeRepository;
import com.example.bilgecollegeapp.repository.ParentRepository;
import com.example.bilgecollegeapp.repository.StudentRepository;
import com.example.bilgecollegeapp.service.abstracts.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    @Override
    public List<ParentListResponse> getAll(){
        List<Parent> parents = parentRepository.findAll();
       return parents.stream().map(r -> new ParentListResponse(r.getFirstName(),r.getLastName())).toList();
    }

    @Override
    public ParentAddResponse add(ParentAddRequest request){
        Student student = studentRepository.findById(request.getStudentId()).orElseThrow();
        Parent parent = ParentMapper.INSTANCE.pRequestMapper(request);
        parent.setStudent(student);
        parentRepository.save(parent);
        ParentAddResponse parentAddResponse = ParentMapper.INSTANCE.pResponseMapper(parent);
        return parentAddResponse;
    }
    @Override
    public ParentUpdateResponse update(ParentUpdateRequest request){
        Parent parent = parentRepository.findById(request.getId()).orElseThrow(() -> new BusinessException("Ebeveyn bulunamamştır"));
        parent.setEmail(request.getEmail());
        parent.setFirstName(request.getFirstName());
        parent.setLastName(request.getLastName());
        parentRepository.save(parent);

        ParentUpdateResponse parentUpdateResponse = new ParentUpdateResponse(request.getEmail(), request.getFirstName(), request.getLastName(), parent.getStudent().getFirstName());
        return parentUpdateResponse;
    }

    @Override
    public List<GradeListResponse> myStudentGrades() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Parent parent = parentRepository.findByEmail(email);
        List<Grade> grade = gradeRepository.findByStudentId(parent.getStudent().getId());

        return
                grade.stream().map(g -> new GradeListResponse(g.getSubject().getName(),g.getGrade1())).toList();

    }
}
