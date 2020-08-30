package com.bitsplease.recruit.test.model;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document("topics")
@Getter
@Setter
public class Topic {
    
    @Id
    @Field("_id")
    private int   id;
    @NotNull
    private String name;
    private String content;
}
