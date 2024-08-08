package com.example.bilgecollegeapp.service.concretes;

import com.example.bilgecollegeapp.core.security.JwtService;
import com.example.bilgecollegeapp.core.exceptionhandling.exception.BusinessException;
import com.example.bilgecollegeapp.model.entity.Parent;
import com.example.bilgecollegeapp.model.entity.Student;
import com.example.bilgecollegeapp.model.entity.Teacher;
import com.example.bilgecollegeapp.repository.ParentRepository;
import com.example.bilgecollegeapp.repository.StudentRepository;
import com.example.bilgecollegeapp.repository.TeacherRepository;
import com.example.bilgecollegeapp.repository.UserRepository;
import com.example.bilgecollegeapp.model.entity.User;
import com.example.bilgecollegeapp.model.enums.Role;
import com.example.bilgecollegeapp.model.dtos.auth.LoginRequest;
import com.example.bilgecollegeapp.model.dtos.auth.RegisterRequest;
import com.example.bilgecollegeapp.model.dtos.auth.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private User user;


    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());



        Authentication authentication =
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        if(!authentication.isAuthenticated()){
            throw new BusinessException("E-posta ya da şifre yanlıştır.");
        }
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("UserId", user.getId());
        extraClaims.put("UserName", user.getFirstName());
        extraClaims.put("UserEmail", user.getEmail());
        extraClaims.put("Role",user.getRole());
        return jwtService.generateToken(user.getUsername(), extraClaims);
    }

    public RegisterResponse register(RegisterRequest request) {
       /* User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.TEACHER);
        userRepository.save(user);
        isTeacher(user,request);*/
        /*Teacher  teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
        teacher.setPassword(passwordEncoder.encode(request.getPassword()));
        teacher.setRole(request.getRole());
        user = teacherRepository.save(teacher);*/
        isTeacher(request);
        isStudent(request);
        isParent(request);


        RegisterResponse response = new RegisterResponse(user.getFirstName(), user.getLastName());
        return response;
    }
    //Business Rules

    public void isTeacher(RegisterRequest request){
        if(request.getRole()==Role.TEACHER){
            Teacher  teacher = new Teacher();
            teacher.setFirstName(request.getFirstName());
            teacher.setLastName(request.getLastName());
            teacher.setEmail(request.getEmail());
            teacher.setPassword(passwordEncoder.encode(request.getPassword()));
            teacher.setRole(request.getRole());
            user = teacherRepository.save(teacher);
        }
    }
    public void isStudent(RegisterRequest request){
        if(request.getRole()==Role.STUDENT){
            Student student = new Student();
            student.setFirstName(request.getFirstName());
            student.setLastName(request.getLastName());
            student.setEmail(request.getEmail());
            student.setPassword(passwordEncoder.encode(request.getPassword()));
            student.setRole(request.getRole());
            user = studentRepository.save(student);
        }
    }
    public void isParent(RegisterRequest request){
        if(request.getRole()==Role.PARENT){
            Parent parent = new Parent();
            parent.setFirstName(request.getFirstName());
            parent.setLastName(request.getLastName());
            parent.setEmail(request.getEmail());
            parent.setPassword(passwordEncoder.encode(request.getPassword()));
            parent.setRole(request.getRole());
            user = parentRepository.save(parent);
        }
    }


}
