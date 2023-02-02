package com.movie.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





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
