package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.core.exceptionhandling.exception.BusinessException;
import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceAddRequest;
import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceAddResponse;
import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceUpdateRequest;
import com.example.bilgecollegeapp.model.dtos.attendance.AttendanceUpdateResponse;
import com.example.bilgecollegeapp.model.entity.Attendance;
import com.example.bilgecollegeapp.model.entity.Student;
import com.example.bilgecollegeapp.repository.AttendanceRepository;
import com.example.bilgecollegeapp.repository.StudentRepository;
import com.example.bilgecollegeapp.service.abstracts.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AttendanceServiceImpl implements AttendanceService{

    private final StudentRepository studentRepository;
    private final AttendanceRepository attendanceRepository;

    @Override
    public AttendanceAddResponse add(AttendanceAddRequest request){
        Student student = studentRepository.findByNumber(request.getStudentNumber());

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(request.getDate());
        attendance.setPresent(false);
        attendanceRepository.save(attendance);

        AttendanceAddResponse response = new AttendanceAddResponse(attendance.getStudent().getNumber(),attendance.getDate(),attendance.isPresent());
        return response;
    }
    @Override
    public AttendanceUpdateResponse update(AttendanceUpdateRequest request){
        Attendance attendance = attendanceRepository.findById(request.getId()).orElseThrow(() -> new BusinessException("Böyle bir yoklama bulunmamaktadır."));
        attendance.setPresent(request.isPresent());

        AttendanceUpdateResponse response = new AttendanceUpdateResponse(attendance.getStudent().getNumber(),attendance.getDate(),attendance.isPresent());
        return response;
    }
}
