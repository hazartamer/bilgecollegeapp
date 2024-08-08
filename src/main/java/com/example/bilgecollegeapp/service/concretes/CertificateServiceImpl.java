package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.model.entity.Certificate;
import com.example.bilgecollegeapp.model.entity.Grade;
import com.example.bilgecollegeapp.model.entity.Student;
import com.example.bilgecollegeapp.repository.CertificateRepository;
import com.example.bilgecollegeapp.repository.GradeRepository;
import com.example.bilgecollegeapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl {
    private final CertificateRepository certificateRepository;
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    @Scheduled(cron = "0 0 12 20 1 ?")
    @Scheduled(cron = "0 0 12 20 1 ?")
    public void tesekkurAlabilirMi(){
        List<Student> studentList = studentRepository.findAll();
        for(Student a:studentList){
            int count = 0;
            List<Grade> grades = gradeRepository.findByStudentId(a.getId());
            for(Grade b : grades){
                count += b.getWithCreditGrade();
            }
            if(count / 4 >= 85){
                Certificate certificate = new Certificate();
                certificate.setType("Takdirname");
                certificate.setStudent(a);
                certificateRepository.save(certificate);
            } else if (count / 4 >=70) {
                Certificate certificate = new Certificate();
                certificate.setType("Teşekkür Belgesi");
                certificate.setStudent(a);
                certificateRepository.save(certificate);
            }
            else {
                Certificate certificate = new Certificate();
                certificate.setType("Siktirname");
                certificate.setStudent(a);
                certificateRepository.save(certificate);
            }
        }
    }
}
