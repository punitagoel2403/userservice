package com.punita.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.punita.userservice.model.UserProfile;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String>{

}
