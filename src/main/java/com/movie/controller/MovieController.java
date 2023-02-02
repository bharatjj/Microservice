package com.movie.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.MovieDto;
import com.movie.repository.MovieRepository;
import com.movie.service.MovieService;

import jakarta.validation.Valid;



@RestController

@RequestMapping("/movie")
public class MovieController {
	
	
	
	

	@Autowired
	MovieRepository movieRepository;
	//MovieRepository movieRepository;
//
	

	@Autowired
	MovieService movieService;
	
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@Valid @RequestBody MovieDto movieDto)
	{
		
		 MovieDto movieDtoValue=movieService.addMovie(movieDto);
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
			
			@GetMapping("/getAllMoview")
			public ResponseEntity<?> allMovie()
			{
				
				 
				Map<String, Object> map= new HashMap<>();
				 map.put("status", 1);
				
				 map.put("data", movieService.getAllMovie());
				 
					return new ResponseEntity<>(map, HttpStatus.OK);
				
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
