package com.elastic.s.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.elastic.s.entity.Movie;

@Repository

public interface MovieMongoRepository extends MongoRepository<Movie, String> {

}
