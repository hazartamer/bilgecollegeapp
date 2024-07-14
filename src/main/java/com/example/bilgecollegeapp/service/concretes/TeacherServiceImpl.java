package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.entity.Teacher;
import com.example.bilgecollegeapp.repository.TeacherRepository;
import com.example.bilgecollegeapp.service.dtos.teacher.TeacherAddRequest;
import com.example.bilgecollegeapp.service.dtos.teacher.TeacherAddResponse;
import com.example.bilgecollegeapp.service.dtos.teacher.TeacherListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl {
    private final TeacherRepository repository;

    public List<TeacherListResponse> getAll(){
        List<Teacher> list = repository.findAll();

        return list.stream().map(r -> new TeacherListResponse(r.getFirstName(),r.getLastName())).toList();
    }

    public TeacherAddResponse add(TeacherAddRequest request){
        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setGender(request.getGender());
        teacher.setBirthDate(request.getBirthdate());

        repository.save(teacher);

        TeacherAddResponse teacherAddResponse = new TeacherAddResponse(teacher.getFirstName(), teacher.getLastName());
        return teacherAddResponse;
    }
}
