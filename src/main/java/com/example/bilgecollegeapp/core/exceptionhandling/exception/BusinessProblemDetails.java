package com.example.bilgecollegeapp.core.exceptionhandling.exception;

public class BusinessProblemDetails extends ProblemDetails
{
    public BusinessProblemDetails(String detail){
        setDetail(detail);
        setTitle("Business Rule Violation");
        setType("BusinessException");
    }
}
