package com.movie.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.movie.entity.Movie;

import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

public interface MovieRepository extends ReactiveElasticsearchRepository<Movie, String> {
	
	
	
	public default  List<Movie> searchAllMovies() throws IOException {

        SearchRequest searchRequest =  SearchRequest.of(s -> s.index(indexName));
        SearchResponse searchResponse =  elasticsearchClient.search(searchRequest, Movie.class);
        List<Hit> hits = searchResponse.hits().hits();
        List<Movie> movies = new ArrayList<>();
        for(Hit object : hits){

            System.out.print(((Movie) object.source()));
            movies.add((Movie) object.source());

        }
        return movies;
    }
	
}