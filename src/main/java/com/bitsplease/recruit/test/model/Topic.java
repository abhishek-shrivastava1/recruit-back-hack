package com.bitsplease.recruit.test.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("topics")
public class Topic {
    
    @Id
    private int    id;
    private String name;
    private String content;
}
