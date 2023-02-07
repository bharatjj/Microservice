package com.elastic.s.service;

import java.util.List;
import java.util.Optional;

import com.elastic.s.entity.Movie;
import com.elastic.s.entity.MovieDto;

public interface MovieService {
	
	

	
	public Iterable<Movie> addMovie(List<Movie> movieDto);
	
	public MovieDto updateMoview(String id,MovieDto priceDto);

	
	public Optional<Movie> getByMovieId(String id);

	public void deleteMovie(String id);

	
	public Iterable<Movie> getAllMovie();


}
