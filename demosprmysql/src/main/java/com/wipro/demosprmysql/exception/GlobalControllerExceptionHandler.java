package com.wipro.demosprmysql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	//@ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(StudentNotFoundException.class)
    public @ResponseStatus ErrorResponse handleStudentNotFoundException(Exception ex)  {
    	return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
    }
}