package com.elastic.s.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elastic.s.entity.Movie;
import com.elastic.s.entity.MovieDto;
import com.elastic.s.repository.MovieElasticRepository;
import com.elastic.s.service.MovieService;




@RestController

@RequestMapping("/movie")
public class MovieController {
	
	
	
	

	@Autowired
	MovieElasticRepository movieRepository;
//
	

	@Autowired
	MovieService movieService;


	
	
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie( @RequestBody List<Movie> movieDto)
	{
		
		 Iterable<Movie> movieDtoValue=movieService.addMovie(movieDto);
		 Map<String, Object> map= new HashMap<>();
		 map.put("status", 1);
		 map.put("Msg", "Movie created Successfully");
		 map.put("data", movieDtoValue);
		 
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		
	}
	

	@PostMapping("/updateMovie/{id}")
	public ResponseEntity<?> updateMovie(@RequestBody MovieDto movieDto,@PathVariable String id)
	{
		
		 Map<String, Object> map= new HashMap<>();

		 try {
		 movieService.updateMoview(id,movieDto);
		 
		 map.put("status", 1);
		 map.put("Msg", "Movie with id" +id+ "updated successfully");
		
		 
		}catch (Exception e) {
			e.printStackTrace();
		}
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		
	}
			
			@GetMapping("/getAllMovie")
			public ResponseEntity<?> allMovie() throws IOException
			{
				
				 
				Map<String, Object> map= new HashMap<>();
				 map.put("status", 1);
				
				 map.put("data", movieService.getAllMovie());
				 
					return new ResponseEntity<>(map, HttpStatus.OK);
				
			}
			
			@GetMapping("/getMovie")
			public ResponseEntity<?> getMovie(@RequestParam String val,@RequestParam String type)
			{
				
				 Map<String, Object> map= new HashMap<>();

				 try {
					 
					 if(type.equals("language"))
					 {
						 Iterable<Movie> mov= movieRepository.findByLanguage(val);
				 
				 map.put("status", 1);
				 map.put("Data", mov);
					 }
					 else
					 {
						 Iterable<Movie> mov= movieRepository.findByGenre(val);
							 map.put("status", 1);
							 map.put("Data", mov);
					 }
				 
				}catch (Exception e) {
					e.printStackTrace();
				}
					return new ResponseEntity<>(map, HttpStatus.CREATED);
				
			}
			
			
			@DeleteMapping("/deleteMovie/{id}")
			public ResponseEntity<?> deleteMovie(@PathVariable String id)
			{
				
				 
				 Map<String, Object> map= new HashMap<>();

				 try {
				 movieService.deleteMovie(id);
				 
				 map.put("status", 1);
				 map.put("Msg", "Movie with id" +id+"  "+ "deleted successfully");
				
				 
				}catch (Exception e) {
					e.printStackTrace();
				}
					return new ResponseEntity<>(map, HttpStatus.OK);
				
			}


}
