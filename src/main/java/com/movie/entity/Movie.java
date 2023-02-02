package com.movie.entity;

import java.math.BigDecimal;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import co.elastic.clients.elasticsearch._types.mapping.FieldType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "movie")
public class Movie {

	
	private String id;

    @Field(name = "movie_name")

	private String movieName;
	
    @Field(name = "genre")

	private String genre;

    @Field(name = "language")

	private String language;

	
	private String tags;

	private String actor_actress;

	private String names;

	private String releasedate;
	
	

	
	
	
}
