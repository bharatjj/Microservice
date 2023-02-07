package com.elastic.s.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName="elastics",type="movie",shards=2)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
	


		
		private String id;

		
		private String movieName;
		
		private String genre;

		
		private String language;

		
		private String tags;

		private String actor_actress;

		private String names;

		private String releasedate;
		

}
