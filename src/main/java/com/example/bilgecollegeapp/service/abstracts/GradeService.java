package com.example.bilgecollegeapp.service.abstracts;

import com.example.bilgecollegeapp.model.dtos.grade.*;

public interface GradeService {

    GradeAddResponse addGrade1(GradeAddRequest request);

    GradeAddResponse addGrade2(Grade2Request request);

    GradeAddResponse addDiscretionaryGrade(GradeDiscretionaryRequest request);

    GradeUpdateResponse updateGrade(GradeUpdateRequest request);
}
