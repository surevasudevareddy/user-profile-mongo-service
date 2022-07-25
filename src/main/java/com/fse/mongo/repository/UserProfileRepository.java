package com.fse.mongo.repository;

import com.fse.mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserProfileRepository extends MongoRepository<User,String> {
    @Query("{name:'?0'}")
    List<User> findAll(String name);
}
