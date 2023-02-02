package com.movie.repository;

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.movie.entity.Movie;

public interface MovieRepository extends ReactiveElasticsearchRepository<Movie, String> {
	
	
	
	
}