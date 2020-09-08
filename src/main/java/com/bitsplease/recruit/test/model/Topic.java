package com.bitsplease.recruit.test.model;

import com.bitsplease.recruit.model.UserAudit;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;

@Getter
@Setter
@Document("topics")
public class Topic extends UserAudit {
    
    private String   name;
    private String   content;
    private Duration videoTime;
}
