package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.entity.Classroom;
import com.example.bilgecollegeapp.entity.Teacher;
import com.example.bilgecollegeapp.mapper.ClassroomMapper;
import com.example.bilgecollegeapp.repository.ClassroomRepository;
import com.example.bilgecollegeapp.repository.TeacherRepository;
import com.example.bilgecollegeapp.service.dtos.classroom.ClassroomAddRequest;
import com.example.bilgecollegeapp.service.dtos.classroom.ClassroomAddResponse;
import com.example.bilgecollegeapp.service.dtos.classroom.ClassroomListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl{
    private final ClassroomRepository classroomRepository;
    private final TeacherRepository teacherRepository;

    public List<ClassroomListResponse> getAll(){
       List<Classroom> classrooms = classroomRepository.findAll();
       return classrooms.stream().map(r -> new ClassroomListResponse(r.getName())).toList();
    }

    public ClassroomAddResponse add(ClassroomAddRequest request){
        Teacher teacher = teacherRepository.findById(request.getMainTeacherId()).orElseThrow();
        Classroom classroom = new Classroom();
        classroom.setName(request.getName());
        classroom.setMainTeacher(teacher);
        classroomRepository.save(classroom);

        ClassroomAddResponse response = new ClassroomAddResponse(classroom.getName());
        return response;
    }
}
