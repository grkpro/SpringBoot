package com.organization.portal.controller.advice;

import com.organization.portal.exception.EmployNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployExceptionController {
    @ExceptionHandler(value = EmployNotFoundException.class)
    public ResponseEntity<Object> exception(EmployNotFoundException notFoundException) {
        return new ResponseEntity<>(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
