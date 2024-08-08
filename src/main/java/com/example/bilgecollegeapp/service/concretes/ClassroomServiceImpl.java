package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.model.entity.Classroom;
import com.example.bilgecollegeapp.model.entity.Teacher;
import com.example.bilgecollegeapp.repository.ClassroomRepository;
import com.example.bilgecollegeapp.repository.TeacherRepository;
import com.example.bilgecollegeapp.model.dtos.classroom.ClassroomAddRequest;
import com.example.bilgecollegeapp.model.dtos.classroom.ClassroomAddResponse;
import com.example.bilgecollegeapp.model.dtos.classroom.ClassroomListResponse;
import com.example.bilgecollegeapp.service.abstracts.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public List<ClassroomListResponse> getAll(){
       List<Classroom> classrooms = classroomRepository.findAll();
       return classrooms.stream().map(r -> new ClassroomListResponse(r.getName())).toList();
    }

    @Override
    public ClassroomAddResponse add(ClassroomAddRequest request){
        Classroom classroom = new Classroom();
        classroom.setName(request.getName());
        classroomRepository.save(classroom);

        ClassroomAddResponse response = new ClassroomAddResponse(classroom.getName());
        return response;
    }

}
