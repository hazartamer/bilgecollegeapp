package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.model.entity.Subject;
import com.example.bilgecollegeapp.repository.SubjectRepository;
import com.example.bilgecollegeapp.model.dtos.subject.SubjectAddRequest;
import com.example.bilgecollegeapp.model.dtos.subject.SubjectAddResponse;
import com.example.bilgecollegeapp.model.dtos.subject.SubjectListResponse;
import com.example.bilgecollegeapp.service.abstracts.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository repository;

    @Override
    public List<SubjectListResponse> getAll(){
        List<Subject> list = repository.findAll();
        return list.stream().map(r -> new SubjectListResponse(r.getName(),r.getDescription())).toList();
    }
    @Override
    public SubjectAddResponse add(SubjectAddRequest request){
        Subject subject = new Subject();
        subject.setName(request.getName());
        subject.setDescription(request.getDescription());
        repository.save(subject);
        return new SubjectAddResponse(subject.getName(),subject.getDescription());
    }
}
