package com.bitsplease.recruit.test.dto;

import com.bitsplease.recruit.dto.UserAuditDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class TopicDto extends UserAuditDto {
    private String name;
    private String content;
    @JsonFormat(pattern = "                                                                                                                                                                                                                                     HH:mm:ss")
    private Duration videoTime;
}
