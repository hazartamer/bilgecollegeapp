package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.mapper.StudentMapper;
import com.example.bilgecollegeapp.model.dtos.student.StudentNotResponse;
import com.example.bilgecollegeapp.model.entity.Classroom;
import com.example.bilgecollegeapp.model.entity.Grade;
import com.example.bilgecollegeapp.model.entity.Student;
import com.example.bilgecollegeapp.repository.ClassroomRepository;
import com.example.bilgecollegeapp.repository.GradeRepository;
import com.example.bilgecollegeapp.repository.StudentRepository;
import com.example.bilgecollegeapp.model.dtos.student.StudentAddRequest;
import com.example.bilgecollegeapp.model.dtos.student.StudentAddResponse;
import com.example.bilgecollegeapp.model.dtos.student.StudentListResponse;
import com.example.bilgecollegeapp.service.abstracts.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final ClassroomRepository classroomRepository;
    private final GradeRepository gradeRepository;


    @Override
    public List<StudentListResponse> getAll(){
        List<Student> all = repository.findAll();
        return all.stream().map(r ->new StudentListResponse(r.getFirstName(),r.getLastName())).toList();
    }

    @Override
    public StudentAddResponse add(StudentAddRequest request){
        Student student = StudentMapper.INSTANCE.sRequestMapper(request);

        repository.save(student);
        StudentAddResponse studentAddResponse = StudentMapper.INSTANCE.sResponseMapper(student);

        return studentAddResponse;
    }
    @Override
    public List<StudentListResponse> getTeacherById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Classroom classroom = classroomRepository.findByMainTeacherEmail(email);
        List<Student> studentList = classroom.getStudentList();
        return studentList.stream().map(r -> new StudentListResponse(r.getFirstName(),r.getLastName())).toList();
    }

    @Override
    public List<StudentNotResponse> myNots(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Student student = repository.findByEmail(email);
        List<Grade> grade = gradeRepository.findByStudentId(student.getId());

       return grade.stream().map(g -> new StudentNotResponse(g.getSubject().getName(),g.getGrade1())).toList();


    }

}
