package com.example.bilgecollegeapp.controller;

import com.example.bilgecollegeapp.model.dtos.grade.*;
import com.example.bilgecollegeapp.service.abstracts.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @PostMapping("grade1")
    @ResponseStatus(HttpStatus.CREATED)
    public GradeAddResponse addGrade1(@RequestBody GradeAddRequest request){
        return gradeService.addGrade1(request);
    }

    @PostMapping("/grade2")
    @ResponseStatus(HttpStatus.CREATED)
    public GradeAddResponse update(@RequestBody Grade2Request request){
        return gradeService.addGrade2(request);
    }

    @PostMapping("/discretionaryGrade")
    @ResponseStatus(HttpStatus.CREATED)
    public GradeAddResponse addDiscretionaryGrade(@RequestBody GradeDiscretionaryRequest request){
        return  gradeService.addDiscretionaryGrade(request);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public GradeUpdateResponse update(@RequestBody GradeUpdateRequest request){
        return  gradeService.updateGrade(request);
    }
}
