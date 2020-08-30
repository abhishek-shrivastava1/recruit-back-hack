package com.bitsplease.recruit.test.controller;

import com.bitsplease.recruit.test.dao.TopicDao;
import com.bitsplease.recruit.test.dto.TopicDto;
import com.bitsplease.recruit.test.model.Topic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class TestController {
    
    @Autowired
    private TopicDao topicDao;
    
    @GetMapping("/{id}")
    public Optional<Topic> getTopic(@PathVariable int id) {
        return topicDao.findById(id);
    }
    
    @PostMapping("/")
    public Topic createTopic(@RequestBody TopicDto topicDto) {
        ModelMapper mapper = new ModelMapper();
        Topic topic = mapper.map(topicDto, Topic.class);
        return topicDao.save(topic);
    }
}
