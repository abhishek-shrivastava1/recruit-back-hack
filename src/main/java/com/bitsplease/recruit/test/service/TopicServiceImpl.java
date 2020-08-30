package com.bitsplease.recruit.test.service;

import com.bitsplease.recruit.test.dto.TopicDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {
    
    @Override public TopicDto create(TopicDto topicDto) {
        return null;
    }
}
