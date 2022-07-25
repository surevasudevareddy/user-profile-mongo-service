package com.fse.mongo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fse.mongo.config.Criteria;
import com.fse.mongo.model.User;
import com.fse.mongo.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userprofile")
public class UserProfileController {
    @Autowired
    UserProfileRepository userProfileRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/userprofiles/")
    public List<User> getAll(){
        return userProfileRepository.findAll();
    }
    @PostMapping("/saveuser")
    public User save(@RequestBody User user){
        return userProfileRepository.save(user);
    }
    @DeleteMapping
    public String delete(@RequestParam String id){
        userProfileRepository.deleteById(id);
        return "Document deleted";
    }
    @PostMapping("/criteria")
    public List<User> findAll(@RequestBody Criteria criteria) throws JsonProcessingException {
        String aIdExpression = (criteria.associateId != null && !criteria.associateId.isBlank())? "'associateId':'"+criteria.associateId+",'":"" ;
        BasicQuery bq = new BasicQuery("{'name':{'$regex':'^"+criteria.name+"','$options':'i'},"+aIdExpression+"skill:{$elemMatch:{'skillName':'"+criteria.skillName+"','expertiseLevel':{'$gte':10}}}}");
        return mongoTemplate.find(bq,User.class);
    }
}