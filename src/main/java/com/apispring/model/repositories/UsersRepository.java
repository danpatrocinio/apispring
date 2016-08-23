package com.apispring.model.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apispring.model.Users;

public interface UsersRepository extends MongoRepository<Users, String> {

}
