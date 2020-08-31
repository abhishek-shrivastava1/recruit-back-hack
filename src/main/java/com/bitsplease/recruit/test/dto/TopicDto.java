package com.bitsplease.recruit.test.dto;

import com.bitsplease.recruit.dto.UserAuditDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicDto extends UserAuditDto {
    private String name;
    private String content;
}
