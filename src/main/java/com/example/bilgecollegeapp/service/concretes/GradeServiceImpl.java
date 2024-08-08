package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.core.exceptionhandling.exception.BusinessException;
import com.example.bilgecollegeapp.core.mail.EmailService;
import com.example.bilgecollegeapp.model.dtos.grade.*;
import com.example.bilgecollegeapp.model.entity.*;
import com.example.bilgecollegeapp.repository.*;
import com.example.bilgecollegeapp.service.abstracts.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final UserRepository userRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private final EmailService emailService;

    @Override
    public GradeAddResponse addGrade1(GradeAddRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();

        User byEmail = userRepository.findByEmail(username);
        Teacher teacher = teacherRepository.findById(byEmail.getId()).orElseThrow();
        Student byNumber = studentRepository.findByNumber(request.getStudentNumber());

        Grade grade = new Grade();
        grade.setStudent(byNumber);
        grade.setSubject(teacher.getSubject());
        grade.setGrade1(request.getGrade1());
        gradeRepository.save(grade);

        String email = getParentEmail(byNumber.getId());
        String subject = "Öğrencinizin Yeni notu";
        String text = "Öğrencinizin yeni notu " + grade.getGrade1();
        emailService.sendSimpleEmail(email, subject, text);

        GradeAddResponse response = new GradeAddResponse(grade.getGrade1(), grade.getStudent().getNumber(),grade.getSubject().getId());
        return response;
    }

    @Override
    public GradeAddResponse addGrade2(Grade2Request request) {
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();*/
        String username = authentication();
        User byEmail = userRepository.findByEmail(username);
        Student sNumber = studentRepository.findByNumber(request.getStudentNumber());
        Teacher teacher = teacherRepository.findById(byEmail.getId()).orElseThrow();
        Grade grade = gradeRepository.findByStudentIdAndSubjectId(sNumber.getId(), teacher.getSubject().getId());

        grade.setGrade2(request.getGrade2());
        grade.setGradeSum((grade.getGrade1() + request.getGrade2() + grade.getDiscretionaryGrade()) / 3);
        grade.setWithCreditGrade(grade.getDiscretionaryGrade() * teacher.getSubject().getCredit());

        gradeRepository.save(grade);
        GradeAddResponse response = new GradeAddResponse(grade.getGrade1(), grade.getStudent().getNumber(),grade.getSubject().getId());
        return response;
    }
    private String getParentEmail(long id){
        Parent parent = parentRepository.findByStudentId(id);
        return parent.getEmail();
    }

    @Override
    public GradeAddResponse addDiscretionaryGrade(GradeDiscretionaryRequest request){
        String email = authentication();
        User byEmail = userRepository.findByEmail(email);
        Student sNumber = studentRepository.findByNumber(request.getStudentNumber());
        Teacher teacher = teacherRepository.findById(byEmail.getId()).orElseThrow(() -> new BusinessException("Böyle bir öğretmen bulunamamıştır"));
        Grade grade = gradeRepository.findByStudentIdAndSubjectId(sNumber.getId(), teacher.getSubject().getId());

        grade.setDiscretionaryGrade(request.getDiscretionaryGrade());
        grade.setGradeSum((grade.getGrade1() + grade.getGrade2() + request.getDiscretionaryGrade()) / 3);
        grade.setWithCreditGrade(grade.getDiscretionaryGrade() * teacher.getSubject().getCredit());

        gradeRepository.save(grade);
        GradeAddResponse response = new GradeAddResponse(grade.getGradeSum(), grade.getStudent().getNumber(),grade.getSubject().getId());
        return response;
    }
    private String authentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    @Override
    public GradeUpdateResponse updateGrade(GradeUpdateRequest request){
        String email = authentication();
        User byEmail = userRepository.findByEmail(email);
        Student sNumber = studentRepository.findByNumber(request.getStudentNumber());
        Teacher teacher = teacherRepository.findById(byEmail.getId()).orElseThrow(() -> new BusinessException("Böyle bir öğretmen bulunamamıştır"));
        Grade grade = gradeRepository.findByStudentIdAndSubjectId(sNumber.getId(), teacher.getSubject().getId());

        grade.setGrade1(request.getGrade1());
        grade.setGrade2(request.getGrade2());
        grade.setDiscretionaryGrade(request.getDiscretionaryGrade());

        grade.setGradeSum((grade.getGrade1() + grade.getGrade2() + request.getDiscretionaryGrade()) / 3);
        grade.setWithCreditGrade(grade.getDiscretionaryGrade() * teacher.getSubject().getCredit());

        gradeRepository.save(grade);
        GradeUpdateResponse response = new GradeUpdateResponse(grade.getGradeSum(), grade.getStudent().getNumber(),grade.getSubject().getId());
        return response;
    }
}
