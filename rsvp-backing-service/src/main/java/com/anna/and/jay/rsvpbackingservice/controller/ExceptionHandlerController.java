package com.anna.and.jay.rsvpbackingservice.controller;

import javassist.NotFoundException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<VndErrors.VndError> notFoundException(NotFoundException e, WebRequest req){
        VndErrors.VndError vndError = new VndErrors.VndError(req.toString(), e.getMessage());
        return new ResponseEntity<>(vndError, HttpStatus.NOT_FOUND);
    }
}
