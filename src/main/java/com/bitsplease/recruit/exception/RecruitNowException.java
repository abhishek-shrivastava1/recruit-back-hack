package com.bitsplease.recruit.exception;

public class RecruitNowException extends RuntimeException {
    
    private int    status;
    private String message;
    
    public RecruitNowException() {
        super();
    }
    
    public RecruitNowException(int status, String error) {
        super();
        this.message = error;
        this.status = status;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
