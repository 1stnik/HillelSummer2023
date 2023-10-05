package com.hillel.springboot.mongo.repository;

import com.hillel.springboot.mongo.model.Developer;
import com.hillel.springboot.mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends MongoRepository<Developer, String> {
}
