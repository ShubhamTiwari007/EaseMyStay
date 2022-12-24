package com.stackroute.userprofileservice.repository;

import com.stackroute.userprofileservice.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, Integer> {
    Users findByEmailId(String emailId);
}
