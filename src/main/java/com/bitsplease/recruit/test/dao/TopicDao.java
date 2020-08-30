package com.bitsplease.recruit.test.dao;

import com.bitsplease.recruit.test.model.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TopicDao extends MongoRepository<Topic, Integer> {
    
    List<Topic> findAllByName(String name);
    
    List<Topic> findAllByNameAndContent(String name, String content);
    
    List<Topic> findAllByNameOrContent(String name, String content);
    
    @Query( value= "from Topic t where t.name = ?1 or t.content= ?2")
    List<Topic> findAllByNameIgnoreCaseOrContent(String name, String content);
}
