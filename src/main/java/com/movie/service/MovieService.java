package com.movie.service;

import java.util.List;

import com.movie.entity.Movie;
import com.movie.entity.MovieDto;

public interface MovieService {
	
	

	
	public MovieDto addMovie(MovieDto movieDto);
	
	public MovieDto updateMoview(String id,MovieDto priceDto);

	
	public Movie getByMovieId(String id);

	public void deleteMovie(String id);

	
	public List<Movie> getAllMovie();


}
