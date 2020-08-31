package com.bitsplease.recruit.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class TimeAudit extends Identity {
    
    @CreatedDate
    private Date createdDate;
    
    @LastModifiedDate
    private Date updatedDate;
}
