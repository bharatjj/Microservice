package com.elastic.s.repository;



import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elastic.s.entity.Movie;


@Repository
public interface MovieElasticRepository extends ElasticsearchRepository<Movie, String> {
	
	
	
	Iterable<Movie> findByGenre(String genre);
	
	Iterable<Movie> findByLanguage(String language);

	
}