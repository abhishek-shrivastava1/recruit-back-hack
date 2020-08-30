package com.bitsplease.recruit.test.dao;

import com.bitsplease.recruit.test.model.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface TopicDao extends MongoRepository<Topic, Integer> {
    
}
