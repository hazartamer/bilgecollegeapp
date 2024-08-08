package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.mapper.TeacherMapper;
import com.example.bilgecollegeapp.model.dtos.student.StudentListResponse;
import com.example.bilgecollegeapp.model.entity.Student;
import com.example.bilgecollegeapp.model.entity.Teacher;
import com.example.bilgecollegeapp.model.entity.User;
import com.example.bilgecollegeapp.repository.ClassroomRepository;
import com.example.bilgecollegeapp.repository.StudentRepository;
import com.example.bilgecollegeapp.repository.TeacherRepository;
import com.example.bilgecollegeapp.model.dtos.teacher.TeacherAddRequest;
import com.example.bilgecollegeapp.model.dtos.teacher.TeacherAddResponse;
import com.example.bilgecollegeapp.model.dtos.teacher.TeacherListResponse;
import com.example.bilgecollegeapp.repository.UserRepository;
import com.example.bilgecollegeapp.service.abstracts.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final ClassroomRepository classroomRepository;
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    @Override
    public List<TeacherListResponse> getAll(){
        List<Teacher> list = teacherRepository.findAll();

        return list.stream().map(r -> new TeacherListResponse(r.getFirstName(),r.getLastName())).toList();
    }

    @Override
    public TeacherAddResponse add(TeacherAddRequest request){
        Teacher teacher = TeacherMapper.INSTANCE.tRequestMapper(request);
        teacherRepository.save(teacher);
        TeacherAddResponse teacherAddResponse = TeacherMapper.INSTANCE.tResponseMapper(teacher);

        return teacherAddResponse;
    }
    @Override
    public List<StudentListResponse> myStudents(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User byEmail = userRepository.findByEmail(username);
        Teacher teacher = teacherRepository.findById(byEmail.getId()).orElseThrow();

        List<Student> getStudents = teacher.getClassroom().getStudentList();

        return getStudents.stream().map(s -> new StudentListResponse(s.getFirstName(),s.getLastName())).toList();



        //

    }
}
