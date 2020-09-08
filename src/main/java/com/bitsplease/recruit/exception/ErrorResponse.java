package com.bitsplease.recruit.exception;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ErrorResponse {
    
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
    private int       status;
    private String    error;
    private String    trace;
    private String    message;
    
    public ErrorResponse(int status, String message, String trace, String error) {
        super();
        this.status = status;
        this.message = message;
        this.trace = trace;
        this.error = error;
    }
    
    public Timestamp getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getError() {
        return error;
    }
    
    public void setError(String error) {
        this.error = error;
    }
    
    public String getTrace() {
        return trace;
    }
    
    public void setTrace(String trace) {
        this.trace = trace;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
