package com.elastic.s.entity;

import java.math.BigDecimal;

import org.springframework.data.elasticsearch.annotations.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="elastics")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Movie {

	
	@Id
	private String id;


	private String movieName;
	

	private String genre;


	private String language;

	
	private String tags;

	private String actor_actress;

	private String names;

	private String releasedate;
	
	

	
	
	
}
