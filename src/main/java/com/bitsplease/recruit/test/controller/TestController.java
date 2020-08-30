package com.bitsplease.recruit.test.controller;

import com.bitsplease.recruit.test.dao.TopicDao;
import com.bitsplease.recruit.test.dto.TopicDto;
import com.bitsplease.recruit.test.model.Topic;
import com.bitsplease.recruit.test.service.TopicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
//@RequestMapping()
public class TestController {
    
/*    @Autowired
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
    }*/
    
    @Autowired
    private TopicDao topicDao;
    @Autowired
    private TopicService topicService;

    @GetMapping("/")
    public List<Topic> helloWorld() {
        return topicDao.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Topic> getTopic(@PathVariable int id) throws Exception {
        return topicDao.findById(id);
    }
    
    @PostMapping("/")
    public TopicDto createTopic(@RequestBody TopicDto topicDto) {
        ModelMapper modelMapper = new ModelMapper();
        Topic topic = modelMapper.map(topicDto, Topic.class);
        topicDao.save(topic);
        return modelMapper.map(topic, TopicDto.class);
    }
    
    /*@PostMapping("/")
    public TopicDto createTopic(@RequestBody TopicDto topicDto) {
        Topic topic = convertToTopicEntity(topicDto);
        topicDao.save(topic);
        return convertToTopicDto(topic);
    }*/
    
    private Topic convertToTopicEntity(TopicDto topicDto) {
        Topic topic = new Topic();
        topic.setId(topicDto.getId());
        topic.setName(topicDto.getName());
        topic.setContent(topicDto.getContent());
        return topic;
    }
    
    private TopicDto convertToTopicDto(Topic topic) {
        TopicDto topicDto = new TopicDto();
        topicDto.setId(topic.getId());
        topicDto.setName(topic.getName());
        topicDto.setContent(topic.getContent());
        return topicDto;
    }
    
    
    @GetMapping("/name/{name}/{content}")
    public List<TopicDto> getByName(@PathVariable String name, @PathVariable String content) {
        ModelMapper modelMapper = new ModelMapper();
        List<Topic> topics = topicDao.findAllByNameOrContent(name, content);
        return topics.stream().map(topic -> modelMapper.map(topic, TopicDto.class)).collect(Collectors.toList());
    }
}
