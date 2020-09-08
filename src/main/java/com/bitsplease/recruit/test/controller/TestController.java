package com.bitsplease.recruit.test.controller;

import com.bitsplease.recruit.exception.RecruitNowException;
import com.bitsplease.recruit.test.dao.TopicDao;
import com.bitsplease.recruit.test.dto.TopicDto;
import com.bitsplease.recruit.test.model.Topic;
import com.bitsplease.recruit.test.service.TopicService;
import com.bitsplease.recruit.utils.ConverterUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private TopicDao     topicDao;
    @Autowired
    private TopicService topicService;
    
    @GetMapping("/")
    public ResponseEntity<List<Topic>> helloWorld() {
        new ResponseEntity<List<Topic>>(topicDao.findAll(), HttpStatus.OK);
        throw new RecruitNowException(HttpStatus.BAD_REQUEST.value(), "My error");
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Topic>> getTopic(@PathVariable String id) throws Exception {
        Optional<Topic> op =topicDao.findById(id);
        if(!op.isPresent()) {
            throw new Exception();
        }
        op.ifPresent(x -> System.out.println(x));
        return new ResponseEntity<Optional<Topic>>(topicDao.findById(id), HttpStatus.OK);
    }
    
    @Autowired
    private ConverterUtils converterUtils;
    
    @PostMapping("/")
    public TopicDto createTopic(@RequestBody TopicDto topicDto) {
        ModelMapper modelMapper = new ModelMapper();
        Topic topic = modelMapper.map(topicDto, Topic.class);
        topicDao.save(topic);
        //        TopicDto topicDto1 = converterUtils.
        
        return modelMapper.map(topic, TopicDto.class);
    }
    
    @PutMapping("/")
    public TopicDto updateTopic(@RequestBody TopicDto topicDto) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Topic> topic = topicDao.findById(topicDto.getId());
        modelMapper.map(topicDto, topic.get());
        topicDao.save(topic.get());
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
