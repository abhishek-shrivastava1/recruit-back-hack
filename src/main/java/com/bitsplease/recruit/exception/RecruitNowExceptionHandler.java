package com.bitsplease.recruit.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class RecruitNowExceptionHandler {
    
    @ExceptionHandler(RecruitNowException.class)
    private Object recruiteNowException(RecruitNowException e, HttpServletResponse response) {
        response.setStatus(e.getStatus());
        return new ErrorResponse(e.getStatus(), e.getMessage(), ExceptionUtils.getStackTrace(e), HttpStatus.valueOf(e.getStatus()).getReasonPhrase());
    }
    
    @ExceptionHandler(Exception.class)
    private Object recruiteNowException(Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), ExceptionUtils.getStackTrace(e), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
}
