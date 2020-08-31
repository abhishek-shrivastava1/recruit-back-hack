package com.bitsplease.recruit.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Identity {
    
    @Id
    private String id;
}
