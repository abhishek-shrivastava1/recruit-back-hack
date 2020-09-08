package com.bitsplease.recruit.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Getter
@Setter
public class UserAudit extends TimeAudit {

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String updatedBy;
}
